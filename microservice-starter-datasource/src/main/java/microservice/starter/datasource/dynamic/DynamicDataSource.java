package microservice.starter.datasource.dynamic;

import java.lang.annotation.*;

/**
 * Target data source selector annotation.
 *
 * @author <a href="mailto:xishizhang@gmail.com">ZhangShixi</a>
 * @version 1.0, 07/20/2012
 */
@Inherited
@Documented
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface DynamicDataSource {

    String value();

}
