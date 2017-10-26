package hu.rendszerfejlesztes.bookshopbackend.controller.beans;

public class Response {

    private boolean success;
    private String message;

    public static Response successWithMessage(String message) {
        Response r = new Response();
        r.success = true;
        r.message = message;
        return r;
    }

    public static Response failureWithMessage(String message) {
        Response r = new Response();
        r.success = false;
        r.message = message;
        return r;
    }

}
