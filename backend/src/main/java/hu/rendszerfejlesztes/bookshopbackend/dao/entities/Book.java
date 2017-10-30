package hu.rendszerfejlesztes.bookshopbackend.dao.entities;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.*;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer isbn;
	private String title;
	private String details;
	private String category;
	private String author;
	private Integer price;
	private boolean onStock;
	private String publisher;
	
	public Book(){
		
	}

	public Integer getIsbn() {
		return isbn;
	}

	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public boolean isOnStock() {
		return onStock;
	}

	public void setOnStock(boolean onStock) {
		this.onStock = onStock;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", details=" + details + ", category=" + category
				+ ", author=" + author + ", price=" + price + ", onStock=" + onStock + ", publisher=" + publisher + "]";
	}
			
}
