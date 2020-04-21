package com.acr.spring_security_jwt.Manager;

import com.acr.spring_security_jwt.Entity.User;
import com.acr.spring_security_jwt.Utility.UserException;

import java.util.List;

public interface IUserManager {
    List<User> GetAll() throws UserException;

    User GetById(int id) throws UserException;

    User Add(User user) throws UserException;

    User Update(int id,User user) throws UserException;

    void Delete(int id) throws UserException;
}
