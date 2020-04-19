package com.acr.spring_security_jwt.Manager;

import com.acr.spring_security_jwt.DAL.IUserDAL;
import com.acr.spring_security_jwt.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class UserManager {
    @Autowired
    private IUserDAL userDAL;

    public List<User> getUsers()
    {
        List<User> users=userDAL.findAll();
        return userDAL.findAll();
    }
}
