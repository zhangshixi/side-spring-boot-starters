package microservice.starter.datasource.dynamic;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Dynamic data source register.
 * <p>
 * Created: 2016-12-08 10:08:35
 *
 * @author Michael.Zhang
 */
public class DynamicDataSourceRegister implements EnvironmentAware, ImportBeanDefinitionRegistrar {

    private DataSource defaultTargetDataSource = null;
    private Map<String, DataSource> defineDataSources = null;

    @Override
    public void setEnvironment(Environment environment) {
        buildDataSources(loadDataSourceConfigs(environment));
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        GenericBeanDefinition dynamicDataSourceBean = new GenericBeanDefinition();
        dynamicDataSourceBean.setBeanClass(DynamicRoutingDataSource.class);
        dynamicDataSourceBean.setSynthetic(true);
        dynamicDataSourceBean.getPropertyValues().addPropertyValue("defaultTargetDataSource", defaultTargetDataSource);
        dynamicDataSourceBean.getPropertyValues().addPropertyValue("targetDataSources", getTargetDataSources());

        beanDefinitionRegistry.registerBeanDefinition("dataSource", dynamicDataSourceBean);
    }

    private Map<String, String> loadDataSourceConfigs(Environment env) {
        Map<String, String> configs = new HashMap<>();

        return configs;
    }

    private void buildDataSources(Map<String, String> configs) {
        // TODO
        this.defaultTargetDataSource = doBuildDataSource(configs);
        this.defineDataSources = null;
    }

    private DataSource doBuildDataSource(Map<String, String> configs) {
        String type = configs.get("type");
        try {
            switch (type) {
                case "com.alibaba.druid.pool.DruidDataSource":
                    return _doBuildDruidDataSource(configs);
                case "com.mchange.v2.c3p0.ComboPooledDataSource":
                    return _doBuildC3p0DataSource(configs);
                case "org.apache.commons.dbcp2.BasicDataSource":
                    return _doBuildDbcp2DataSource(configs);
                default:
                    throw new UnsupportedOperationException();
            }
        } catch (Exception ex) {
            throw new RuntimeException("Build data source error!", ex);
        }
    }

    private DataSource _doBuildDruidDataSource(Map<String, String> configs) throws Exception {
        return DruidDataSourceFactory.createDataSource(configs);
    }

    private DataSource _doBuildC3p0DataSource(Map<String, String> configs) {
        throw new UnsupportedOperationException();
    }

    private DataSource _doBuildDbcp2DataSource(Map<String, String> configs) {
        throw new UnsupportedOperationException();
    }

    private Object getTargetDataSources() {
        Map<String, DataSource> targetDataSources = new HashMap<>();
        targetDataSources.put("defaultTargetDataSource", defaultTargetDataSource);
        targetDataSources.putAll(defineDataSources);

        return targetDataSources;
    }

}