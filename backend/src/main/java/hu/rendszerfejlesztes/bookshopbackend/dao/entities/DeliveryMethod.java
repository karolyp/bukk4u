package hu.rendszerfejlesztes.bookshopbackend.dao.entities;

/**
 * Created by Ákos on 2017.10.31..
 */
public enum DeliveryMethod {

    POST("POST"),
    COURIER("COURIER"),
    PERSONALLY("PERSONALLY"),
    PACKAGEAUTOMATA("PACKAGEAUTOMATA");

    private String delivery;

    DeliveryMethod(String delivery){
        this.delivery = delivery;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }


}
