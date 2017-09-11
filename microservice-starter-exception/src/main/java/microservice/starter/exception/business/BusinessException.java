package microservice.starter.exception.business;

import microservice.starter.exception.ErrorCodeException;

/**
 * Created: 2017-09-10 20:18:02
 *
 * @author Michael.Zhang
 */
public class BusinessException extends ErrorCodeException {

    public BusinessException(int responseCode, String responseMessage) {
        super(responseCode, responseMessage);
    }

}