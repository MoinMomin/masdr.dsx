package interaction.cx.masdr.sa.controller;

import interaction.cx.masdr.sa.config.TenantAwareMongoTemplate;
import interaction.cx.masdr.sa.config.TenantContext;
import interaction.cx.masdr.sa.model.User;
//import interaction.cx.masdr.sa.service.DynamicCollectionService;
import interaction.cx.masdr.sa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class userController {
    @Autowired
    UserService userService;
   /* @Autowired
    DynamicCollectionService dynamicCollectionService;*/
    @Autowired
    private TenantAwareMongoTemplate tenantAwareMongoTemplate;
    @GetMapping("/getuserdata")
    public ResponseEntity<Map> getuserData(@RequestParam int id){
        User user=userService.findByUserId(id);
       return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/tenant-data")
    public List<Object> getTenantData(@RequestParam("tenantId") String tenantId) {
        // Set the tenantId in TenantContext
        TenantContext.setCurrentTenantId(tenantId);

        try {
            MongoTemplate mongoTemplate = tenantAwareMongoTemplate.getMongoTemplate();
            // Interact with the tenant-specific database
            // Replace Object.class and "collection_name" with your document class and collection name
            return mongoTemplate.findAll(Object.class, "collection_name");
        } finally {
            // Clear the context after the request is complete
            TenantContext.clear();

        }
    }

    @PostMapping("/tenant-data")
    public String createTenantData(@RequestParam("tenantId") String tenantId, @RequestBody User data) {
        // Set the tenantId in TenantContext
        TenantContext.setCurrentTenantId(tenantId);

        try {
            MongoTemplate mongoTemplate = tenantAwareMongoTemplate.getMongoTemplate();
            mongoTemplate.insert(data, "collection_name");  // Insert data into the tenant's database
            return "Data inserted for tenant: " + tenantId;
        } finally {
            // Clear the context after the request is complete
            TenantContext.clear();
        }
    }

}
