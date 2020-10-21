package dao;

import java.util.List;
import java.util.Optional;
import model.User;

public interface UserDao {
    void add(User user);

    List<User> listUsers();

    Optional<User> getById(Long id);
}
