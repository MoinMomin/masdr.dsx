package interaction.cx.masdr.sa.controller;
import interaction.cx.masdr.sa.config.TenantContext;
import interaction.cx.masdr.sa.model.Product;
//import interaction.cx.masdr.sa.service.TenantService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TenantController {

/*  @Autowired
    TenantService tenantService;
  @PostMapping("/createproduct")
    public ResponseEntity<Map> createProduct(@RequestBody Product product, @Param("tenant") String tenantId){
      tenantService.createProduct(tenantId,product);
      return new ResponseEntity<>(HttpStatus.CREATED);
  }*/
}
