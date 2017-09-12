package microservice.starter.exception;

/**
 * Error code exception.
 * <p>
 * Created: 2017-09-11 23:00:00
 *
 * @author Michael.Zhang
 */
public class ErrorCodeException extends RuntimeException {

    private int responseCode;

    public ErrorCodeException(int responseCode) {
        this(responseCode, (String) null);
    }

    public ErrorCodeException(int responseCode, String responseMessage) {
        this(responseCode, responseMessage, null);
    }

    public ErrorCodeException(int responseCode, Throwable cause) {
        this(responseCode, cause == null ? null : cause.getMessage(), cause);
    }

    public ErrorCodeException(int responseCode, String responseMessage, Throwable cause) {
        super(responseMessage, cause, true, true);
        this.responseCode = responseCode;
    }

    public int getResponseCode() {
        return responseCode;
    }

}
