package com.securewebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String getHome() {
        return "home";
    }

    @GetMapping("/securesauce")
    public String getSecureSauce() {
        return "secureSauce";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }
}
