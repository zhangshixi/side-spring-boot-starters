package microservice.starter.common.request;

import java.io.Serializable;

/**
 * Base request.
 * <p>
 * Created: 2017-09-12 12:47:10
 *
 * @author Michael.Zhang
 */
public class BaseRequest implements Serializable {

    private String applicationId;

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

}
