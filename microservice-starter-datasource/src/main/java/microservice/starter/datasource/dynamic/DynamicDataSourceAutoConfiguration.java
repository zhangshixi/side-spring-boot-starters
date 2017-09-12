package microservice.starter.datasource.dynamic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created: 2017-09-10 19:44:25
 *
 * @author Michael.Zhang
 */
@Configuration
@EnableConfigurationProperties(DynamicDataSourceProperties.class)
public class DynamicDataSourceAutoConfiguration {

    @Autowired
    private DynamicDataSourceProperties dataSourceProperties;

}
