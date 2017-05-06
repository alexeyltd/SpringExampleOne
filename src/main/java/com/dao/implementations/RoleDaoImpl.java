package com.dao.implementations;

import com.dao.abstracts.RoleDao;
import com.model.Role;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Transactional
@Repository
public class RoleDaoImpl extends AbstractDao<Long, Role> implements RoleDao {

    public Role getRoleByRoleName(String roleName) {
        return (Role) getSession().createQuery("FROM Role WHERE name = :name").setParameter("name", roleName).uniqueResult();
    }

}
