package interaction.cx.masdr.sa.service;

import interaction.cx.masdr.sa.model.User;

public interface UserService {
    public User createUser(User user);
    public User findByUserId(int Id);
}
