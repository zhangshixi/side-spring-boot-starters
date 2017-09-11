package microservice.starter.exception.business;

import javax.servlet.http.HttpServletResponse;

/**
 * 400 bad request exception.
 * <p>
 * Created on 2015-10-20 10:08:35
 *
 * @author Michael.Zhang
 */
public class ParameterException extends BusinessException {

    /**
     * Response code of parameter error.
     */
    public static final int RESPONSE_CODE = HttpServletResponse.SC_BAD_REQUEST;

    public ParameterException(String responseMessage) {
        super(RESPONSE_CODE, responseMessage);
    }

    public ParameterException(int responseCode, String responseMessage) {
        super(responseCode, responseMessage);
    }

}