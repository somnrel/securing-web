package com.example.controller;

import com.example.entity.UserInfo;
import com.example.entity.enumVar.Role;
import com.example.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Instant;
import java.util.Date;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserInfoRepository userRepository;

    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "userList"; // Вернёт шаблон user/list.html
    }

    @GetMapping("/new")
    public String newUserForm(Model model) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserID(1);
        userInfo.setPasswordHash("1");
        userInfo.setRole(Role.ADMIN);
        userInfo.setEmail("test@gamil.com");
        userInfo.setUsername("test");
        userInfo.setCreatedAt(Date.from(Instant.now()));
        model.addAttribute("user", userInfo);
        return "userNew"; // Вернёт шаблон user/new.html
    }

    @PostMapping("/save")
    public String saveUser(UserInfo user) {
        userRepository.save(user);
        return "redirect:/userList"; // Перенаправление на список пользователей
    }
}  