package interaction.cx.masdr.sa.config;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class TenantAwareMongoTemplate {

    public MongoTemplate getMongoTemplate() {
        String tenantId = TenantContext.getCurrentTenantId();
        return MongoTemplateProvider.getMongoTemplate(tenantId);
    }
}
