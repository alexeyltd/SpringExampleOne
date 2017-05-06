package com.dao.abstracts;

import com.model.Role;
import com.model.User;

import java.util.List;


public interface RoleDao extends GenericDao<Long,Role> {

    Role getRoleByRoleName(String roleName);

}
