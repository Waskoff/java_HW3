public class PhoneNumberAlreadyExistsException extends Exception{
    public PhoneNumberAlreadyExistsException() {
    }

    public PhoneNumberAlreadyExistsException(String message) {
        super(message);
    }

    public PhoneNumberAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public PhoneNumberAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    public PhoneNumberAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
