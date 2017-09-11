package microservice.starter.exception.business;

import javax.servlet.http.HttpServletResponse;

/**
 * 404 not found exception.
 * <p>
 * Created on 2015-10-20 10:08:35
 *
 * @author Michael.Zhang
 */
public class NotFoundException extends BusinessException {

    /**
     * Response code of not found.
     */
    public static final int RESPONSE_CODE = HttpServletResponse.SC_NOT_FOUND;

    public NotFoundException(String responseMessage) {
        super(RESPONSE_CODE, responseMessage);
    }

    public NotFoundException(int responseCode, String responseMessage) {
        super(responseCode, responseMessage);
    }

}
