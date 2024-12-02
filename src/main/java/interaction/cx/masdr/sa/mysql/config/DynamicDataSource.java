package interaction.cx.masdr.sa.mysql.config;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        // Determine the current lookup key (tenant ID or another context)
        return TenantContext.getTenantId();
    }
}
