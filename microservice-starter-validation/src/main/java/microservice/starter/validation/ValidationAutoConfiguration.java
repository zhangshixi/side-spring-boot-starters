package microservice.starter.validation;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * Created: 2017-09-12 10:16:32
 *
 * @author Michael.Zhang
 */
@Configuration
@ConditionalOnWebApplication
@ConditionalOnClass({RequestMapping.class, Valid.class})
public class ValidationAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public MethodValidationPostProcessor getMethodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }

}