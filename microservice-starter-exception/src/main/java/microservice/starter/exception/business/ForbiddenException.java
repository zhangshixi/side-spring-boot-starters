package microservice.starter.exception.business;

import javax.servlet.http.HttpServletResponse;

/**
 * 403 forbidden exception.
 * <p>
 * Created on 2015-10-20 10:08:35
 *
 * @author Michael.Zhang
 */
public class ForbiddenException extends BusinessException {

    /**
     * Response code of forbidden.
     */
    public static final int RESPONSE_CODE = HttpServletResponse.SC_FORBIDDEN;

    public ForbiddenException(String responseMessage) {
        this(RESPONSE_CODE, responseMessage);
    }

    public ForbiddenException(int responseCode, String responseMessage) {
        super(responseCode, responseMessage);
    }

}
