package com.acr.spring_security_jwt.Manager;

import com.acr.spring_security_jwt.DAL.IUserDAL;
import com.acr.spring_security_jwt.Entity.User;
import com.acr.spring_security_jwt.Utility.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class UserManager {
    @Autowired
    private IUserDAL userDAL;

    public List<User> getUsers() throws NoResultException {
        List<User> users=userDAL.findAll();
        if(users==null || users.size()==0)
        {
            throw new NoResultException("No User exists");
        }
        return userDAL.findAll();
    }

    public User AddUser(User _user) throws NoResultException {
        User user=userDAL.Add(_user);
        if(user.getUsername().isEmpty()||user.getPassword().isEmpty()||user.getEnabled()==null)
        {
            throw new NoResultException("Please fill all the details");
        }
        return user;
    }
}
