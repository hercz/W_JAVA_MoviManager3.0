package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MovieManagerServer
{
	private ServerMode mode;
	private ServerSocket serverSocket = null;
	private Socket server = null;

	public void runningServer() throws IOException
	{

		try
		{
			System.out.println("---S_E_R_V_E_R---\n");
			System.out.println("Starting server...");
			serverSocket = new ServerSocket(4445);
			System.out.println("Waiting for connection...");
			server = serverSocket.accept();
			System.out.println("The client is connected to the server");

			// output
			ObjectOutputStream streamToClient = new ObjectOutputStream(server.getOutputStream());

			// input
			ObjectInputStream streamFromClient = new ObjectInputStream(server.getInputStream());

			// TEST
			while (true)
			{
				if (streamFromClient.read() > -1)
				{
					Object comeIn = null;
					comeIn = streamFromClient.readObject();
					if (comeIn instanceof Command && ((Command) comeIn == Command.EXIT))
					{
						System.out.println("Exit command received, terminating server process");
						break;
					} else if (comeIn instanceof Command && ((Command) comeIn == Command.PUT))
					{
						System.out.println("Put command received, ServerMode swich to SAVE mode.");
						mode = ServerMode.SAVE;
					} else if (comeIn instanceof Command && ((Command) comeIn == Command.GET))
					{
						System.out.println("Get command received, ServerMode swich to LOAD mode.");
						mode = ServerMode.LOAD;
						Object listToClient = load();
						System.out.println("Load objects from file, and send to the Client.");
						List<Object> objectListFromFile = (List<Object>) listToClient;
						streamToClient.writeObject(listToClient);

					} else if (mode == ServerMode.SAVE)
					{
						System.out.println("Saving to file");
						save(comeIn);

					}
				}
			}

			serverSocket.close();
			server.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public List<Object> load() throws IOException, ClassNotFoundException
	{
		List<Object> objectsFromFile = new ArrayList<>();

		try
		{
			FileInputStream fromFile = new FileInputStream("storage.ser");
			ObjectInputStream incomingObjects = new ObjectInputStream(fromFile);
			while (true)
			{
				try
				{
					objectsFromFile.add(incomingObjects.readObject());
				} catch (Exception e)
				{
					break;
				}
				fromFile.close();
				incomingObjects.close();

			}
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}

		return objectsFromFile;
	}

	public void save(Object comeIn) throws IOException
	{
		try
		{
			FileOutputStream outToFile = new FileOutputStream("storage.ser", true);
			ObjectOutputStream objectOut = new ObjectOutputStream(outToFile);
			objectOut.writeObject(comeIn);
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws IOException
	{
		MovieManagerServer server = new MovieManagerServer();
		server.runningServer();

	}
}