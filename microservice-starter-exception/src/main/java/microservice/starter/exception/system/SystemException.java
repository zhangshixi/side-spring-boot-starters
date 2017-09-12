package microservice.starter.exception.system;

import microservice.starter.exception.ErrorCodeException;

/**
 * Created: 2017-09-10 20:20:18
 *
 * @author Michael.Zhang
 */
public class SystemException extends ErrorCodeException {

    /**
     * Response code of system exception.
     */
    public static final int RESPONSE_CODE = -1;

    public SystemException(String responseMessage) {
        this(RESPONSE_CODE, responseMessage);
    }

    public SystemException(int responseCode, String responseMessage) {
        this(responseCode, responseMessage, null);
    }

    public SystemException(int responseCode, Throwable cause) {
        this(responseCode, cause == null ? null : cause.getMessage(), cause);
    }

    public SystemException(int responseCode, String responseMessage, Throwable cause) {
        super(responseCode, responseMessage, cause);
    }

}
