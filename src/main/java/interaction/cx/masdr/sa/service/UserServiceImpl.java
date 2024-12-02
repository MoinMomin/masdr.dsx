package interaction.cx.masdr.sa.service;

import interaction.cx.masdr.sa.model.User;
import interaction.cx.masdr.sa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findByUserId(int Id) {
        return userRepository.findByUserId(Id);
    }
}
