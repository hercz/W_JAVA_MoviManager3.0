package application;

public abstract class Product {
	protected String id;
	protected String title;
	protected Person person;

	public Product(String title, Person person) {
		this.id = IdGenerator.generate(this);
		this.title = title;
		this.person = person;
	}

	public String getTitle() {
		return title;
	}

	public Person getPerson() {
		return person;
	}

	public abstract long getInvestment();

}
