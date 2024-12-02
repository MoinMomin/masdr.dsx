package interaction.cx.masdr.sa.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class User {
    private Integer userId;
    private String name;
}
