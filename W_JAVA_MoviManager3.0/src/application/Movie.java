package application;

import java.util.ArrayList;
import java.util.List;

public class Movie extends Product implements Buyable {

	private Genre genre;
	private long duration;
	private double rate;
	List<Person> cast;
	private int price;

	public Movie(String title, Person person, Genre genre, long duration, double rate, List<Person> cast, int price) {
		super(title, person);
		this.genre = genre;
		this.duration = duration;
		this.rate = rate;
		this.cast = cast;
		this.price = price;

	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public List<Person> getCast() {
		return cast;
	}

	public void setCast(ArrayList<Person> cast) {
		this.cast = cast;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public int getPrice() {
		return price;

	}

	@Override
	public long getInvestment() {
		long investment = 0;
		for (Person person : cast) {
			investment += person.salary;
		}
		return investment;

	}

	@Override
	public String toString() {
		return "Unique ID: " + id + "\nTitle: " + title + "\nGenre: " + genre + "\nDuration: " + duration + "\nRate: "
				+ rate + "\nCast: " + cast;
	}
}
