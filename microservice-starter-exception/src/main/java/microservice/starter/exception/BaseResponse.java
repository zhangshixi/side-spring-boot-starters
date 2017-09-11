package microservice.starter.exception;

import java.io.Serializable;

/**
 * Base response.
 * <p>
 * Created on 2016-12-10 16:39:38
 *
 * @author Michael.Zhang
 */
public class BaseResponse implements Serializable {

    private int responseCode;
    private String responseMessage;

    public BaseResponse() {
    }

    public BaseResponse(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public BaseResponse(int responseCode, String responseMessage) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

}
