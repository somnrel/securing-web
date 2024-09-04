package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.entity.UserInfo;
import com.example.service.UserService;

@RestController
@Controller
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/auth")
    public String auth() {
        return "Welcome this endpoint is not secure";
    }

    @PostMapping("/create/user")
    public String addNewUser(@RequestBody UserInfo userInfo){
        return service.addUser(userInfo);
    }
}


