package microservice.starter.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created: 2017-09-10 20:47:40
 *
 * @author Michael.Zhang
 */
@Configuration
@ConditionalOnWebApplication
@ConditionalOnClass(RequestMapping.class)
@Import(ExceptionMvcGlobalHandler.class)
public class ExceptionAutoConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionAutoConfiguration.class);

    public ExceptionAutoConfiguration() {
        LOGGER.info("Constructor initialize: {}", getClass());
    }

}
