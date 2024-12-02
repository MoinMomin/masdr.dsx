package interaction.cx.masdr.sa.mysql.config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfig {

    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.url}")
    private String defaultUrl;

    @Value("${tenant.db1.url}")
    private String tenantDb1Url;

    @Value("${tenant.db2.url}")
    private String tenantDb2Url;

    @Value("${tenant.db3.url}")
    private String tenantDb3Url;

    @Bean
    public DataSource dataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();

        // Default (fallback) database connection
        DataSource defaultDataSource = createDataSource(defaultUrl);

        // Tenant-specific database connections
        DataSource tenantDb1 = createDataSource(tenantDb1Url);
        DataSource tenantDb2 = createDataSource(tenantDb2Url);
        DataSource tenantDb3 = createDataSource(tenantDb3Url);

        // Map tenant IDs to their respective data sources
        Map<Object, Object> dataSourceMap = new HashMap<>();
        dataSourceMap.put("db1", tenantDb1);
        dataSourceMap.put("db2", tenantDb2);
        dataSourceMap.put("db3", tenantDb3);

        dynamicDataSource.setTargetDataSources(dataSourceMap);
        dynamicDataSource.setDefaultTargetDataSource(defaultDataSource);

        return dynamicDataSource;
    }

    private DataSource createDataSource(String url) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
