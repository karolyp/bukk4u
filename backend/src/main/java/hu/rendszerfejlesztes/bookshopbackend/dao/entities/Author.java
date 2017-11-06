package hu.rendszerfejlesztes.bookshopbackend.dao.entities;

import org.omg.CORBA.portable.IDLEntity;
import org.springframework.boot.autoconfigure.web.ResourceProperties;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer authorId;
    private String authorName;

    @ManyToOne(cascade = CascadeType.ALL)
    private Book book;

    public Author() {
    }

    public Author(Integer authorId, String authorName, Book book) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.book = book;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", authorName='" + authorName + '\'' +
                '}';
    }
}
