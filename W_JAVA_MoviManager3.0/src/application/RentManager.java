package application;

import java.util.ArrayList;
import java.util.List;

public class RentManager
{

	public static int totalIncome(List<Buyable> buyables)
	{
		int totalIncome = 0;
		for (Buyable buyable : buyables)
		{
			totalIncome += buyable.getPrice();
		}
		return totalIncome;
	}

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
		Book book2 = new Book("Ketkonyvcim", c2, ba2);

		// total income
		List<Buyable> buyables = new ArrayList<Buyable>();
		buyables.add(game1);
		buyables.add(game2);
		buyables.add(movie1);
		buyables.add(movie2);

		// TESTS
		System.out.println("The total income from the buyable products:" + totalIncome(buyables) + "$");
		System.out.println("\nProduct examples:\n");
		System.out.println("\n" + movie1 + "\nTOTAL INVESTMENT: " + movie1.getInvestment() + "$");
		System.out.println("\n" + game2 + "\nTOTAL INVESTMENT: " + game2.getInvestment() + "$");
		System.out.println("\n" + book1 + "\nTOTAL INVESTMENT: " + book1.getInvestment() + "$");

	}

}
