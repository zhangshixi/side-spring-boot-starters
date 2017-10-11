package microservice.starter.common.resonse;

import java.io.Serializable;

/**
 * Base response.
 * <p>
 * Created on 2016-12-10 16:39:38
 *
 * @author Michael.Zhang
 */
public class BaseResponse<T> implements Serializable {

    private int responseCode;
    private String responseMessage;
    private T responseBody;

    public BaseResponse() {
    }

    public BaseResponse(int responseCode) {
        this.responseCode = responseCode;
    }

    public BaseResponse(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public BaseResponse(T responseBody) {
        this.responseBody = responseBody;
    }

    public BaseResponse(int responseCode, String responseMessage) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
    }

    public BaseResponse(int responseCode, T responseBody) {
        this.responseCode = responseCode;
        this.responseBody = responseBody;
    }

    public BaseResponse(String responseMessage, T responseBody) {
        this.responseMessage = responseMessage;
        this.responseBody = responseBody;
    }

    public BaseResponse(int responseCode, String responseMessage, T responseBody) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
        this.responseBody = responseBody;
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

    public T getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(T responseBody) {
        this.responseBody = responseBody;
    }

}
