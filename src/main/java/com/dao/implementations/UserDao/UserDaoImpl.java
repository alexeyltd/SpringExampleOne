package com.dao.implementations.UserDao;

import com.dao.abstracts.UserDao.UserDAO;
import com.dao.implementations.Exceptions.UserDaoImplException;
import com.model.User;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;


@Transactional
@Repository
public class UserDaoImpl implements UserDAO {

    @PersistenceContext
    EntityManager entityManager;


    public User getOneUser(String login, String password) {

        User user = entityManager.createQuery(
                "SELECT u from User u WHERE u.login = :login", User.class)
                .setParameter("login", login).getSingleResult();

        return user;
    }


    public List<User> getUsers() throws UserDaoImplException {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> cq = builder.createQuery(User.class);
        Root<User> root = cq.from(User.class);
        cq.select(root);

        return entityManager.createQuery(cq).getResultList();

    }


    @Override
    public void addUser(User user) throws UserDaoImplException {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User user) throws UserDaoImplException {
        entityManager.merge(user);
    }

    @Override
    public void deleteUser(long id) throws UserDaoImplException {

        User user = entityManager.find(User.class, id);
        entityManager.remove(user);

    }
}
