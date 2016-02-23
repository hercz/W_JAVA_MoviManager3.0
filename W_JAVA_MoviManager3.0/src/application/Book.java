package application;

import java.io.Serializable;

public class Book extends Product implements Serializable
{

	Person author;

	public Book(String title, Person person, Person author)
	{
		super(title, person);
		this.author = author;
	}

	public Person getAuthor()
	{
		return author;
	}

	public void setAuthor(Person author)
	{
		this.author = author;
	}

	@Override
	public long getInvestment()
	{
		return author.salary;
	}

	@Override
	public String toString()
	{
		return "Unique ID: " + id + "\nTitle: " + title + "\nCustomer: " + person + "\nAuthor: " + author;
	}
}
