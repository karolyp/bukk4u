package hu.rendszerfejlesztes.bookshopbackend.dao.entities;

/**
 * Created by Ákos on 2017.10.31..
 */
public enum PaymentMethod {

    CASH("CASH"),
    VOUCHER("VOUCHER"),
    CREDITCARD("CREDITCARD");

    private String payment;

    PaymentMethod(String payment){
        this.payment = payment;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

}
