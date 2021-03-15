package com.avgona.spam.bot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {

    @GetMapping("/authorization")
    public String loginForm(){
        return "authorization/Authorization";
    }

    @GetMapping("/access-denied")
    public String accessDenied(){
        return "authorization/access-denied";
    }
}