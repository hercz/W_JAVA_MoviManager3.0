package application;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MovieManagerClient
{

	public static void main(String[] args)
	{
		// PERSONS
		// actors/actresses for movies
		Person a1 = new Person("Jason", "Statham", Gender.MALE, 1155);
		Person a2 = new Person("Silvester", "Stallone", Gender.MALE, 1212);
		Person a3 = new Person("Emma", "Wattson", Gender.FEMALE, 1131);
		Person a4 = new Person("Brad", "Pitt", Gender.MALE, 1140);
		Person a5 = new Person("Angelina", "Jolie", Gender.FEMALE, 2300);

		// staff persons for games
		Person s1 = new Person("Dezso", "Jatekos", Gender.MALE, 110);
		Person s2 = new Person("Boldizsar", "Jatekos", Gender.MALE, 120);
		Person s3 = new Person("Jeno", "Jatekos", Gender.MALE, 130);

		// authors for books
		Person ba1 = new Person("Dezso", "Kosztolanyi", Gender.MALE, 50);
		Person ba2 = new Person("Kalman", "Mikszath", Gender.MALE, 55);
		Person ba3 = new Person("Ferenc", "Mora", Gender.MALE, 52);
		Person ba4 = new Person("Zsigmond", "Moricz", Gender.MALE, 69);

		// customers for products
		Person c1 = new Person("Jakab", "Josua", Gender.MALE, 20);
		Person c2 = new Person("Aranka", "Hogyishivjak", Gender.FEMALE, 12);
		Person c3 = new Person("Nyomo", "Reka", Gender.FEMALE, 22);
		Person c4 = new Person("Kopcos", "Tibor", Gender.MALE, 10);
		Person c5 = new Person("Mathazer", "Imre", Gender.MALE, 18);

		// MOVIES
		List<Person> movie1cast = new ArrayList<Person>();
		movie1cast.add(a1);
		movie1cast.add(a2);
		Movie movie1 = new Movie("Mr&Mrs Smith", c2, Genre.ACTION, 120, 8.5, movie1cast, 15);

		List<Person> movie2cast = new ArrayList<Person>();
		movie2cast.add(a3);
		movie2cast.add(a4);
		movie2cast.add(a5);
		Movie movie2 = new Movie("Alien", c3, Genre.COMEDY, 120, 8.0, movie2cast, 25);

		// GAMES
		List<Person> game1cast = new ArrayList<Person>();
		game1cast.add(s1);
		game1cast.add(s2);
		Game game1 = new Game("Halo5", c4, false, game1cast, 12);

		List<Person> game2cast = new ArrayList<Person>();
		game2cast.add(s2);
		game2cast.add(s3);
		Game game2 = new Game("Halo6", c5, true, game2cast, 10);

		// BOOKS
		Book book1 = new Book("Egykonyvcim", c1, ba1);
		Product book2 = new Book("Ketkonyvcim", c2, ba2);

		// ---C_O_N_N_E_C_T___T_O___S_E_R_V_E_R---
		try
		{
			System.out.println("---C_L_I_E_N_T---\n");
			Socket client = new Socket("localhost", 4445);
			System.out.println("Client Connected");

			// input
			ObjectInputStream streamFromServer = new ObjectInputStream(client.getInputStream());

			// output
			ObjectOutputStream streamToServer = new ObjectOutputStream(client.getOutputStream());

			// ---S_E_N_D_I_N_G__C_O_M_M_A_N_D_S---
			// you can switch by comment/uncomment these

			// ---EXIT---
			// System.out.println("Sending command EXIT");
			// send(streamToServer, Command.EXIT);
			// System.out.println("Server shut down");

			// ---PUT---
			System.out.println("Sending command PUT");
			send(streamToServer, Command.PUT);
			System.out.println("Server shut down");

			System.out.println("Sending object to the server");
			send(streamToServer, movie1);
			send(streamToServer, a2);

			// ---GET---
			// System.out.println("Sending command GET");
			// send(streamToServer, Command.GET);
			// System.out.println("Server shut down");
			// Object dataFromFile = streamFromServer.readObject();
			// if (dataFromFile instanceof List)
			// {
			// List<Object> objects = (List<Object>) dataFromFile;
			// for (Object object : objects)
			// {
			// System.out.println(object);
			// }
			// send(streamToServer, Command.EXIT);
			// }

			// C_L_O_S_E
			System.out.println("Closing the connection from the client side");
			client.close();
			System.out.println("Connection closed");

		} catch (Exception e)
		{
			e.printStackTrace();

		}

	}

	public static void send(ObjectOutputStream sendto, Object objectToSend)
	{
		try
		{
			sendto.write(0);
			sendto.writeObject(objectToSend);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
