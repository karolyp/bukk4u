package hu.rendszerfejlesztes.bookshopbackend.controller.beans;

public class Response {

    private boolean success;
    private String message;

    public Response(){

    }

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

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
