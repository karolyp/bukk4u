package hu.rendszerfejlesztes.bookshopbackend.dao.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Rating {
    @Id
    @GeneratedValue
    private Integer ratingsId;
    private Integer score;
    private boolean isFavorite = false;

    @ManyToOne
    private User user;
    @ManyToOne
    private Book bookRating;

    public Rating() { }

    public Rating(Integer ratingsId, Integer score, boolean isFavorite, User user, Book bookRating) {
        this.ratingsId = ratingsId;
        this.score = score;
        this.isFavorite = isFavorite;
        this.user = user;
        this.bookRating = bookRating;
    }

    public Integer getRatingsId() {
        return ratingsId;
    }

    public void setRatingsId(Integer ratingsId) {
        this.ratingsId = ratingsId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return bookRating;
    }

    public void setBook(Book book) {
        this.bookRating = bookRating;
    }

    @Override
    public String toString() {
        return "Ratings{" +
                "ratingsId=" + ratingsId +
                ", score=" + score +
                ", isFavorite=" + isFavorite +
                ", user=" + user +
                ", bookRating=" + bookRating +
                '}';
    }
}
