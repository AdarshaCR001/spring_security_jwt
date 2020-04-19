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
        try {
            List<User> users = userManager.getUsers();

            if (users == null || users.size() == 0) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.ok(users);
            }
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
    public User get(@RequestBody User user)
    {
        return new User();
    }
}
