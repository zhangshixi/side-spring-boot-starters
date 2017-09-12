package microservice.starter.exception;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created: 2017-09-10 20:47:40
 *
 * @author Michael.Zhang
 */
@Configuration
@ConditionalOnWebApplication
@ConditionalOnClass({Controller.class, RequestMapping.class})
@Import({GlobalExceptionHandlerAdvice.class, GlobalResponseBodyAdvice.class})
public class ExceptionAutoConfiguration {

}
