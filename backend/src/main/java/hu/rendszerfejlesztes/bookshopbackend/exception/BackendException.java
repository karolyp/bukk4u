package hu.rendszerfejlesztes.bookshopbackend.exception;

public class BackendException extends Exception {
    public BackendException() {
    }

    public BackendException(String message) {
        super(message);
    }
}
