package pro.sky_curse.work.update.Employee_accounting.exception;

public class InvalidEmployeeNameException extends RuntimeException {
    public InvalidEmployeeNameException() {
    }

    public InvalidEmployeeNameException(String message) {
        super(message);
    }

    public InvalidEmployeeNameException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidEmployeeNameException(Throwable cause) {
        super(cause);
    }

    public InvalidEmployeeNameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
