package service.impl;

import dao.UserDao;
import java.util.List;
import model.User;
import org.springframework.stereotype.Service;
import service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add(User user) {
        userDao.add(user);
    }

    public List<User> listUsers() {
        return userDao.listUsers();
    }

    public User getById(Long id) {
        return userDao.getById(id).get();
    }
}
