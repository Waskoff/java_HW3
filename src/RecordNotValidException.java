public class RecordNotValidException extends Exception{
    public RecordNotValidException() {
    }

    public RecordNotValidException(String message) {
        super(message);
    }

    public RecordNotValidException(String message, Throwable cause) {
        super(message, cause);
    }

    public RecordNotValidException(Throwable cause) {
        super(cause);
    }

    public RecordNotValidException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
