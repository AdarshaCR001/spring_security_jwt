package com.acr.spring_security_jwt.DAL;

import com.acr.spring_security_jwt.Entity.Role;
import com.acr.spring_security_jwt.Entity.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

public class RoleDAL implements IRoleDAL {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Role> GetAll() {
        Session currentSession=entityManager.unwrap(Session.class);

        List<Role> roles=currentSession.createQuery("SELECT r FROM Role r LEFT JOIN FETCH r.users User",Role.class).getResultList();

        return roles;
    }

    @Override
    public Role GetById(int id) {
        Session currentSession=entityManager.unwrap(Session.class);

        Role roles=currentSession.createQuery("SELECT r FROM Role r LEFT JOIN FETCH r.roles WHERE r.id = 1",Role.class).getSingleResult();

        return roles;
    }

    @Override
    public Role AddOrUpdate(Role role) {
        return null;
    }

    @Override
    public Boolean Delete(int id) {
        return null;
    }
}
