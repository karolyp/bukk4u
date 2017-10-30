package hu.rendszerfejlesztes.bookshopbackend.dao.entities;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.*;

@Entity
public class Basket {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer basketID;
	private Integer isbn;
	private Integer id;
	private Integer amount;
	private Integer totalPrice;
	private Integer orderId;
	
	public Basket(){}
	
	public Basket(Integer basketID, Integer isbn, Integer id, Integer amount, Integer totalPrice, Integer orderId) {
		super();
		this.basketID = basketID;
		this.isbn = isbn;
		this.id = id;
		this.amount = amount;
		this.totalPrice = totalPrice;
		this.orderId = orderId;
	}
	
	public Integer getBasketID() {
		return basketID;
	}
	public void setBasketID(Integer basketID) {
		this.basketID = basketID;
	}
	public Integer getIsbn() {
		return isbn;
	}
	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Integer getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	
	@Override
	public String toString() {
		return "Basket [basketID=" + basketID + ", isbn=" + isbn + ", id=" + id + ", amount=" + amount + ", totalPrice="
				+ totalPrice + ", orderId=" + orderId + "]";
	}
	
	
}
