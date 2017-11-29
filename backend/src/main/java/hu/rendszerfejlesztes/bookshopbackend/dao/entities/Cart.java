package hu.rendszerfejlesztes.bookshopbackend.dao.entities;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer cartID;
    private Integer amount;

    @OneToMany(mappedBy="cart")
    private Set<CartElement> products = new HashSet<CartElement>();

    @OneToOne
    private BookOrder order;

    @OneToOne
    private Customer customer;

    public Cart(){}

    public Cart(Integer cartID, Integer amount, Set<CartElement> products, BookOrder order, Customer customer) {
        this.cartID = cartID;
        this.amount = amount;
        this.products = products;
        this.order = order;
        this.customer = customer;
    }

    public Integer getCartID() {
        return cartID;
    }

    public void setCartID(Integer cartID) {
        this.cartID = cartID;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Set<CartElement> getProducts() {
        return products;
    }

    public void setProducts(Set<CartElement> products) {
        this.products = products;
    }

    public BookOrder getOrder() {
        return order;
    }

    public void setOrder(BookOrder order) {
        this.order = order;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartID=" + cartID +
                ", amount=" + amount +
                ", products=" + products +
                ", order=" + order +
                ", customer=" + customer +
                '}';
    }
}
