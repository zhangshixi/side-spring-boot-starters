package microservice.starter.datasource.dynamic;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created: 2017-09-10 19:37:49
 *
 * @author Michael.Zhang
 */
@ConfigurationProperties(prefix = "dynamic.datasource")
public class DynamicDataSourceProperties {

    private String defaultTargetDataSource;

}
