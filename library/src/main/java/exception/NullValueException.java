package exception;

public class NullValueException extends Exception {
    public NullValueException() {
        super();
    }

    public NullValueException(String message) {
        super(message);
    }

    public NullValueException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullValueException(Throwable cause) {
        super(cause);
    }

    public NullValueException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
