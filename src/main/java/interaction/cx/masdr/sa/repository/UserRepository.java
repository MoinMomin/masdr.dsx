package interaction.cx.masdr.sa.repository;

import interaction.cx.masdr.sa.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,Integer> {
    public User save(User user);
    public User findByUserId(int userId);
}
