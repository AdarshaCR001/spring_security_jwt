package com.acr.spring_security_jwt.Controller;

import com.acr.spring_security_jwt.Entity.User;
import com.acr.spring_security_jwt.Manager.IUserManager;
import com.acr.spring_security_jwt.Manager.UserManager;
import com.acr.spring_security_jwt.Utility.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserManager userManager;

    @GetMapping("/")
    public ResponseEntity GetAll()
    {
        try
        {
            List<User> users = userManager.GetAll();
            return ResponseEntity.ok(users);
        }
        catch (UserException e)
        {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(e.getMessage());
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity Get(@PathVariable int userId)
    {
        try
        {
            User user = userManager.GetById(userId);
            return ResponseEntity.ok(user);
        }
        catch (UserException e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/")
    public ResponseEntity Add(@RequestBody User user)
    {
        try {
            User r_user=userManager.Add(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(r_user);
        }
        catch (UserException e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/{userId}")
    public ResponseEntity Update(@PathVariable int userId,@RequestBody User user)
    {
        try {
            User r_user=userManager.Update(userId,user);
            return ResponseEntity.status(HttpStatus.CREATED).body(r_user);
        }
        catch (UserException e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity Delete(@PathVariable int userId)
    {
        try {
            userManager.Delete(userId);
            return ResponseEntity.status(HttpStatus.OK).body("Deleted Successfully");
        }
        catch (UserException e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
