package com.acr.spring_security_jwt.DAL;

import com.acr.spring_security_jwt.Entity.Role;
import com.acr.spring_security_jwt.Entity.User;

import java.util.List;

public interface IRoleDAL {
    public List<Role> GetAll();
    public Role GetById(int id);
    public Role AddOrUpdate(Role role);
    public Boolean Delete(int id);
}
