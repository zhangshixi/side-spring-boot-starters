package microservice.starter.datasource.dynamic;

/**
 * Dynamic Data source hold manager.
 * Use {@link ThreadLocal} bind the data source to the thread.
 * <p>
 * Created: 2016-12-03 13:14:28
 *
 * @author Michael.Zhang
 * @see ThreadLocal
 */
public class DynamicDataSourceHolder {

    private static final ThreadLocal<String> DATA_SOURCE_HOLDER = new ThreadLocal<>();

    public static void setCurrentDataSource(String dataSource) {
        DATA_SOURCE_HOLDER.set(dataSource);
    }

    public static String getCurrentDataSource() {
        return DATA_SOURCE_HOLDER.get();
    }

    public static void removeDataSource() {
        DATA_SOURCE_HOLDER.remove();
    }

}

