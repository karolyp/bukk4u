package hu.rendszerfejlesztes.bookshopbackend.dao.entities;

import static javax.persistence.GenerationType.IDENTITY;


import javax.persistence.*;

@Entity
public class Order {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer orderId;
	private String email;
	private Integer basketId;
	private String paymentMethod;
	private String shipping;
	private String status;
	
	public Order(){}
	
	public Order(Integer orderId, String email, Integer basketId, String paymentMethod, String shipping,
			String status) {
		super();
		this.orderId = orderId;
		this.email = email;
		this.basketId = basketId;
		this.paymentMethod = paymentMethod;
		this.shipping = shipping;
		this.status = status;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getBasketId() {
		return basketId;
	}
	public void setBasketId(Integer basketId) {
		this.basketId = basketId;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getShipping() {
		return shipping;
	}
	public void setShipping(String shipping) {
		this.shipping = shipping;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", email=" + email + ", basketId=" + basketId + ", paymentMethod="
				+ paymentMethod + ", shipping=" + shipping + ", status=" + status + "]";
	}
	
	
	
	
}
