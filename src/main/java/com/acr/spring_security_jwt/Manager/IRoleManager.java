package com.acr.spring_security_jwt.Manager;

import com.acr.spring_security_jwt.Entity.Role;
import com.acr.spring_security_jwt.Utility.UserException;

public interface IRoleManager {
    Role GetAll() throws UserException;

    Role GetById(int id) throws UserException;

    Role Add(Role role) throws UserException;

    Role Update(int id,Role role) throws UserException;

    void Delete(int id) throws UserException;
}
