package microservice.starter.exception.system;

/**
 * Data missing exception.
 * <p>
 * Created: 2017-09-10 22:46:05
 *
 * @author Michael.Zhang
 */
public class DataMissingException extends SystemException {

    public DataMissingException(String responseMessage) {
        super(responseMessage);
    }

    public DataMissingException(int responseCode, String responseMessage) {
        this(responseCode, responseMessage, null);
    }

    public DataMissingException(int responseCode, Throwable cause) {
        this(responseCode, cause == null ? null : cause.getMessage(), cause);
    }

    public DataMissingException(int responseCode, String responseMessage, Throwable cause) {
        super(responseCode, responseMessage, cause);
    }

}