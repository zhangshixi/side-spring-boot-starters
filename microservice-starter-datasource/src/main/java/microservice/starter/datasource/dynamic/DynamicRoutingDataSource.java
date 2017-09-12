package microservice.starter.datasource.dynamic;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Dynamic naming data source routing.
 * Using which data source by the name witch bind in the current thread.
 * <p>
 * Created: 2012-02-02 18:54:23
 *
 * @author Michael.Zhang
 * @see DynamicDataSourceHolder
 */
public class DynamicRoutingDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceHolder.getCurrentDataSource();
    }

}