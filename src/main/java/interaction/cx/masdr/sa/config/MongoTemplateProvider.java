package interaction.cx.masdr.sa.config;

import org.springframework.data.mongodb.core.MongoTemplate;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class MongoTemplateProvider {

    private static final Map<String, MongoTemplate> mongoTemplates = new ConcurrentHashMap<>();
    private static final String CONNECTION_STRING = "mongodb://localhost:27017";
    // Retrieves or creates a MongoTemplate instance for the given tenantId
    public static MongoTemplate getMongoTemplate(String tenantId) {
        return mongoTemplates.computeIfAbsent(tenantId, MongoTemplateProvider::createMongoTemplate);
    }

    // Creates a new MongoTemplate instance for the given tenantId
    private static MongoTemplate createMongoTemplate(String tenantId) {
        String databaseName = "db_" + tenantId; // Customize database name as needed
        MongoClient mongoClient = MongoClients.create(CONNECTION_STRING);

        // Initialize the database for the tenant if needed
        MongoTemplate mongoTemplate = new MongoTemplate(mongoClient, databaseName);
        // You could optionally check or create collections here as needed for new tenants
        return mongoTemplate;
    }
}
