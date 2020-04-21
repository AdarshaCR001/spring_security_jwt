package com.acr.spring_security_jwt.DAL;

import com.acr.spring_security_jwt.Entity.User;

import java.util.List;

public interface IUserDAL {

    public List<User> GetAll();
    public User GetById(int id);
    public User AddOrUpdate(User user);
    public Boolean Delete(int id);
}
