package com.acr.spring_security_jwt.DAL;

import com.acr.spring_security_jwt.Entity.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDAL implements IUserDAL {

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<User> findAll() {

        Session currentSession=entityManager.unwrap(Session.class);

        List<User> users=currentSession.createQuery("from User",User.class).getResultList();

        return users;
    }

    @Override
    public User Add(User user) {
        Session currentSession=entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(user);

        //Id will be automatically updated in user after save
        return user;
    }
}
