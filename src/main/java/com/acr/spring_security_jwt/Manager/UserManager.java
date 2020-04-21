package com.acr.spring_security_jwt.Manager;

import com.acr.spring_security_jwt.DAL.IUserDAL;
import com.acr.spring_security_jwt.Entity.User;
import com.acr.spring_security_jwt.Utility.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserManager implements IUserManager {
    @Autowired
    private IUserDAL userDAL;

    @Override
    public List<User> GetAll() throws UserException {
        List<User> users=userDAL.GetAll();
        if(users==null || users.size()==0)
        {
            throw new UserException("No User exists.");
        }
        return userDAL.GetAll();
    }

    @Override
    public User GetById(int id) throws UserException {
        if(id<=0)
        {
            throw new UserException("Please enter correct id.");
        }
        User user=userDAL.GetById(id);
        if(user==null)
        {
            throw new UserException("No User exist with given Id.");
        }
        return user;
    }

    @Override
    public User Add(User user) throws UserException {
        if(user.getUsername().isEmpty()||user.getPassword().isEmpty()||user.getEnabled()==null)
        {
            throw new UserException("Please fill all the details.");
        }
        if(user.getId()>0)
        {
            throw new UserException("Please don't add id while creating.");
        }
        User res_user=userDAL.AddOrUpdate(user);
        return res_user;
    }

    @Override
    public User Update(int id, User user) throws UserException {
        if(id<=0)
        {
            throw new UserException("Please enter correct id.");
        }
        user.setId(id);
        if(user.getUsername().isEmpty()||user.getPassword().isEmpty()||user.getEnabled()==null)
        {
            throw new UserException("Please fill all the details.");
        }
        User res_user=userDAL.AddOrUpdate(user);
        return res_user;
    }

    @Override
    public void Delete(int id) throws UserException {
        if(id<=0)
        {
            throw new UserException("Please enter correct id.");
        }
        Boolean isUserDeleted=userDAL.Delete(id);
        if(!isUserDeleted)
        {
            throw new UserException("User doesn't exist to delete.");
        }
    }
}
