package com.acr.spring_security_jwt.DAL;

import com.acr.spring_security_jwt.Entity.User;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class UserDAL implements IUserDAL {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<User> GetAll() {

        Session currentSession=entityManager.unwrap(Session.class);

        List<User> users=currentSession.createQuery("SELECT u FROM User u LEFT JOIN FETCH u.roles Role",User.class).getResultList();

        return users;
    }

    @Override
    public User GetById(int id) {

        Session currentSession=entityManager.unwrap(Session.class);

        User user=currentSession.createQuery("SELECT u FROM User u LEFT JOIN FETCH u.roles WHERE u.id = 1",User.class).getSingleResult();

        System.out.println(user.toString());

        return user;
    }

    @Override
    public User AddOrUpdate(User user) {

        Session currentSession=entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(user);

        //Id will be automatically updated in user after save
        return user;
    }

    @Override
    public Boolean Delete(int id) {

        Session currentSession=entityManager.unwrap(Session.class);

        User user=GetById(id);
        if(user!=null)
        {
            //User exists
            currentSession.delete(user);
            return true;
        }

        //User doesn't exists
        return false;
    }
}
