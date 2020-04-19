package com.acr.spring_security_jwt.Controller;

import com.acr.spring_security_jwt.DAL.IUserDAL;
import com.acr.spring_security_jwt.Entity.User;
import com.acr.spring_security_jwt.Manager.UserManager;
import com.acr.spring_security_jwt.Utility.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserManager userManager;

    @GetMapping("/")
    public ResponseEntity getAll()
    {
        try
        {
            List<User> users = userManager.getUsers();
            return ResponseEntity.ok(users);
        }
        catch (NoResultException e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/")
    public ResponseEntity get(@RequestBody User user)
    {
        try {
            User r_user=userManager.AddUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(r_user);
        }
        catch (NoResultException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
