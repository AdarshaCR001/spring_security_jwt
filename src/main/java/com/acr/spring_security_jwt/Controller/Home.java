package com.acr.spring_security_jwt.Controller;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {

    @GetMapping("/")
    public String Welcome()
    {
        return "Welcome";
    }

    @GetMapping("/home")
    public String home()
    {
        return "Home page";
    }

    @GetMapping("/admin")
    public String Admin()
    {
        return "Admin page";
    }

    @GetMapping("/user")
    public String User()
    {
        return "User page";
    }

}
