/*
package interaction.cx.masdr.sa.service;
import interaction.cx.masdr.sa.model.Product;
import interaction.cx.masdr.sa.mysql.config.TenantContext;
import interaction.cx.masdr.sa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TenantService {

    @Autowired
    private ProductRepository repository;

    public void createProduct(String tenantId, Product product) {
        TenantContext.setTenantId(tenantId);

        repository.save(product);
    }
}
*/
