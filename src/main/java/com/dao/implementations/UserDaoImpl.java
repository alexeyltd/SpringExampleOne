package com.dao.implementations;

import com.dao.abstracts.UserDao;
import com.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


@Transactional
@Repository
public class UserDaoImpl extends AbstractDao<Long, User> implements UserDao {

    public User getUserByUsername(String username) {
        User user = (User) entityManager.createQuery("SELECT u FROM User u WHERE u.login =:username").setParameter("username", username).getSingleResult();
        return user;
    }

}
