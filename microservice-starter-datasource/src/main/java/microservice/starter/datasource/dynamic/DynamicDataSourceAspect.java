package microservice.starter.datasource.dynamic;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

/**
 * @author Michael.Zhang
 */
@Aspect
@Order(0)
public class DynamicDataSourceAspect {

    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceAspect.class);

    @Before("@annotation(microservice.starter.datasource.dynamic.DynamicDataSource)")
    public void switchDataSource(JoinPoint joinPoint, DynamicDataSource targetDataSource) throws Throwable {
        DynamicDataSourceHolder.setCurrentDataSource(targetDataSource.value());
        logger.debug("-->Switch to dataSource: {}", targetDataSource);
    }

    @After("@annotation(microservice.starter.datasource.dynamic.DynamicDataSource)")
    public void removeDataSource(JoinPoint joinPoint) throws Throwable {
        DynamicDataSourceHolder.removeDataSource();
        logger.debug("<--Remove switched dataSource.");
    }

}
