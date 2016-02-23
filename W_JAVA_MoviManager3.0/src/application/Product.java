package application;

import java.io.Serializable;

public abstract class Product implements Serializable
{
	protected String id;
	protected String title;
	protected Person person;

	public Product(String title, Person person)
	{
		this.id = IdGenerator.generate(this);
		this.title = title;
		this.person = person;
	}

	public String getTitle()
	{
		return title;
	}

	public Person getPerson()
	{
		return person;
	}

	public abstract long getInvestment();

}
