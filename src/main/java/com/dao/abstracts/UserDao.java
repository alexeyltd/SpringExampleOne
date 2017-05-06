package com.dao.abstracts;


import com.model.User;

import java.util.List;

public interface UserDao extends GenericDao<Long,User>{
     User getUserByUsername(String username);
}
