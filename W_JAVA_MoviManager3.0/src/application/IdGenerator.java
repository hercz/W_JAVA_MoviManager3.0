package application;

import java.io.Serializable;
import java.util.UUID;

public class IdGenerator implements Serializable
{

	public static String generate(Product product)
	{
		String randomID = UUID.randomUUID().toString();
		String uniqueID = "";
		if (product instanceof Game)
		{
			uniqueID = "GAM" + randomID;
		}
		if (product instanceof Movie)
		{
			uniqueID = "MOV" + randomID;
		}
		if (product instanceof Book)
		{
			uniqueID = "BOO" + randomID;
		}
		return uniqueID;
	}
}
