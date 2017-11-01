package hu.rendszerfejlesztes.bookshopbackend.dao.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Book {
	@Id
	private Long isbn;

	private String title;
	private String description;
    private Integer price;
    private Integer inStock;
    private String publisher;
    private String thumbnail;

	@Column(name = "date")
    private java.sql.Date releaseDate;

	@OneToMany(mappedBy="book")
	private Set<Author> authors = new HashSet<Author>();

    @OneToMany(mappedBy="bookRating")
    private Set<Ratings> ratings = new HashSet<Ratings>();

	@Enumerated(value = EnumType.STRING)
	private Category category;

	public Book(){	}

    public Book(Long isbn, String title, String description, Integer price, Integer inStock,
                String publisher, String thumbnail, Date releaseDate, Set<Author> authors,
                Set<Ratings> ratings, Category category) {
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.price = price;
        this.inStock = inStock;
        this.publisher = publisher;
        this.thumbnail = thumbnail;
        this.releaseDate = releaseDate;
        this.authors = authors;
        this.ratings = ratings;
        this.category = category;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Set<Ratings> getRatings() {
        return ratings;
    }

    public void setRatings(Set<Ratings> ratings) {
        this.ratings = ratings;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getInStock() {
        return inStock;
    }

    public void setInStock(Integer inStock) {
        this.inStock = inStock;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", inStock=" + inStock +
                ", publisher='" + publisher + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", releaseDate=" + releaseDate +
                ", authors=" + authors +
                ", ratings=" + ratings +
                ", category=" + category +
                '}';
    }
}
