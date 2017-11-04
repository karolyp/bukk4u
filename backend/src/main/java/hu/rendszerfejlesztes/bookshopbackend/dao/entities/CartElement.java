package hu.rendszerfejlesztes.bookshopbackend.dao.entities;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class CartElement {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer cartElementId;
    private Integer quantity;

    @OneToOne
    private Book book;

    @ManyToOne(cascade= CascadeType.ALL)
    private Cart cart;

    public CartElement() {}

    public CartElement(Integer cartElementId, Integer quantity, Book book, Cart cart) {
        this.cartElementId = cartElementId;
        this.quantity = quantity;
        this.book = book;
        this.cart = cart;
    }

    public Integer getCartElementId() {
        return cartElementId;
    }

    public void setCartElementId(Integer cartElementId) {
        this.cartElementId = cartElementId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "CartElement{" +
                "cartElementId=" + cartElementId +
                ", quantity=" + quantity +
                ", book=" + book +
                ", cart=" + cart +
                '}';
    }
}
