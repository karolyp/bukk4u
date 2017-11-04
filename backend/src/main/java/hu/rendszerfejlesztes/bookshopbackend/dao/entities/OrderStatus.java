package hu.rendszerfejlesztes.bookshopbackend.dao.entities;

/**
 * Created by Ákos on 2017.10.31..
 */
public enum OrderStatus {

    NEW("NEW"),
    PENDING("PENDING"),
    SUCCEEDED("SUCCEEDED"),
    FAILED("FAILED");

    private String order;

    OrderStatus(String order) {
        this.order = order;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

}
