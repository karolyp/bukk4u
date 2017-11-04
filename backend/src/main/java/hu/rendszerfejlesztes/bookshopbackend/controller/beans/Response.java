package hu.rendszerfejlesztes.bookshopbackend.controller.beans;

public class Response {

    private boolean success;
    private String message;
    private static Response response = new Response();

    private Response(){

    }

    public static Response successWithMessage(String message) {
        response.success = true;
        response.message = message;
        return response;
    }

    public static Response failureWithMessage(String message) {
        response.success = false;
        response.message = message;
        return response;
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
