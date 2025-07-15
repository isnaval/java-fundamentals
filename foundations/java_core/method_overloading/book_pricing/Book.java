package java_core.method_overloading.book_pricing;

public class Book {
	private String title;
	private String author;
	private double basePrice;
	private String category;

	public Book(String title, String author, double basePrice, String category) {
		this.title = title;
		this.author = author;
		this.basePrice = basePrice;
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public String getCategory() {
		return category;
	}

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	@Override
	public String toString() {
		return title + " por " + author + " - €" + basePrice + " (" + category + ")";
	}

}
