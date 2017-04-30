package com.services.implementations.userServiceImpl;


import com.dao.abstracts.UserDao.UserDAO;
import com.dao.implementations.Exceptions.UserDaoImplException;
import com.model.User;
import com.services.abstracts.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;


    @Override

    public void addUser(User user) throws UserDaoImplException {
        userDAO.addUser(user);
    }

    @Override

    public void updateUser(User user) throws UserDaoImplException {
        userDAO.updateUser(user);
    }

    @Override

    public void deleteUser(long id) throws UserDaoImplException {
        userDAO.deleteUser(id);

    }

    @Override

    public List<User> getUsers() throws UserDaoImplException {
        return userDAO.getUsers();
    }

    @Override

    public User getOneUser(String login, String password) {
        return userDAO.getOneUser(login, password);
    }
}
