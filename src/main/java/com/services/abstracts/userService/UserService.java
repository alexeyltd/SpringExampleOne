package com.services.abstracts.userService;


import com.dao.implementations.Exceptions.UserDaoImplException;
import com.model.User;

import java.util.List;

/**
 * Created by alexeypavlenko on 23/04/2017.
 */
public interface UserService {

     void addUser(User user) throws UserDaoImplException;

     void updateUser(User user) throws UserDaoImplException;

     void deleteUser(long id) throws UserDaoImplException;

     List<User> getUsers() throws UserDaoImplException;

     User getOneUser(String login, String password);

}
