package com.acr.spring_security_jwt.DAL;

import com.acr.spring_security_jwt.Entity.User;

import java.util.List;

public interface IUserDAL {

    public List<User> findAll();
    public User Add(User user);
}
