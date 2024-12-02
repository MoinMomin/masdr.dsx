/*
package interaction.cx.masdr.sa.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class DynamicCollectionService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void createCollectionIfNotExists(String collectionName) {
        if (!mongoTemplate.collectionExists(collectionName)) {
            mongoTemplate.createCollection(collectionName);
        }
    }

    public void insertDocument(String collectionName, Object document) {
        createCollectionIfNotExists(collectionName);
        mongoTemplate.insert(document, collectionName);
    }
}
*/
