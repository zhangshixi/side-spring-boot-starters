package microservice.starter.exception;

/**
 * Error code exception.
 * 
 * Created: 2017-09-11 23:00:00
 *
 * @author  Michael.Zhang
 */
public class ErrorCodeException extends RuntimeException {

    private int responseCode;

    public ErrorCodeException(int responseCode) {
        super(null, null, true, false);
        this.responseCode = responseCode;
    }

    public ErrorCodeException(int responseCode, String responseMessage) {
        super(responseMessage, null, true, false);
        this.responseCode = responseCode;
    }

    public ErrorCodeException(int responseCode, Throwable cause) {
        super(cause.getMessage(), cause, true, true);
        this.responseCode = responseCode;
    }

    public ErrorCodeException(int responseCode, String responseMessage, Throwable cause) {
        super(responseMessage, cause, true, true);
        this.responseCode = responseCode;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

}
