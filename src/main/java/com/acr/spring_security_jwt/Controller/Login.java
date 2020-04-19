package com.acr.spring_security_jwt.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Login {

    @GetMapping("/login")
    public String Login()
    {
        return "Login";
    }

}
