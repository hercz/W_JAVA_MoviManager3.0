package application;

import java.util.Date;
import java.util.List;

public class Game extends Product implements Buyable {
	boolean preOrdered;
	List<Person> staff;
	int price;
	int year;
	private Date today = new Date();

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Game(String title, Person person, boolean preOrdered, List<Person> staff, int price, int year) {
		super(title, person);
		Date today = new Date();

		this.preOrdered = (preOrdered && (today.getYear() < year));
		this.staff = staff;
		this.price = price;
		this.year = year;
	}

	public boolean isPreOrdered() {
		return preOrdered;
	}

	public void setPreOrdered(boolean preOrdered) {
		this.preOrdered = preOrdered;
	}

	public List<Person> getStaff() {
		return staff;
	}

	public void setStaff(List<Person> staff) {
		this.staff = (List<Person>) staff;
	}

	@Override
	public int getPrice() {
		double discount = (2016 - year) / 10;

		if (preOrdered) {
			price = (int) (price * 0.8);
		} else {
			price = (int) (price * discount);
		}
		return price;

		// (int) (preOrdered ? price * 0.8 : price);
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public long getInvestment() {
		long investment = 0;
		for (Person person : staff) {
			investment += person.salary;
		}
		return investment;
	}

	@Override
	public String toString() {
		return "Unique ID: " + id + "\n" + "Title: " + title + "\n" + "Customer: " + person + "\n" + "Preodered: "
				+ preOrdered + "\n" + "Staff: " + staff + "\n" + "Price: " + price;
	}
}
