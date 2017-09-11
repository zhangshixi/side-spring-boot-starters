package microservice.starter.exception.system;

/**
 * Data missing exception.
 * 
 * Created: 2017-09-10 22:46:05
 *
 * @author  Michael.Zhang
 */
public class DataMissingException extends SystemException {

    public DataMissingException(String responseMessage) {
        super(responseMessage);
    }

    public DataMissingException(int responseCode, String responseMessage) {
        super(responseCode, responseMessage);
    }

    public DataMissingException(int responseCode, Throwable cause) {
        super(responseCode, cause);
    }

    public DataMissingException(int responseCode, String responseMessage, Throwable cause) {
        super(responseCode, responseMessage, cause);
    }

}