package com.dao.abstracts.UserDao;


import com.dao.implementations.Exceptions.UserDaoImplException;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.util.List;

public interface UserDAO {

     void addUser(User user) throws UserDaoImplException;

     void updateUser(User user) throws UserDaoImplException;

     void deleteUser(long id) throws UserDaoImplException;

     List<User> getUsers() throws UserDaoImplException;

     User getOneUser(String login, String password);

}
