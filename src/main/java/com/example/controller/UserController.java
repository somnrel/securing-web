package com.example.controller;

import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.entity.TransactionInfo;
import com.example.entity.UserInfo;
import com.example.service.TransactionService;
import com.example.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/auth")
    public String auth() {
        return "Welcome this endpoint is not secure";
    }

    @GetMapping("registration")
    public String showRegistrationForm(Model model) {
        UserInfo userInfo = new UserInfo();
        model.addAttribute("userInfo", userInfo);
        return "registration";
    }

    @PostMapping("/create/user")
    public String addNewUser(@ModelAttribute UserInfo userInfo, Model model){
        model.addAttribute("userInfo", userInfo);
        service.addUser(userInfo);
        return "redirect:/login?registration_success";
    }

    @GetMapping("/privateOffice")
    public String getModelForPrivateOffice(Model model, Principal principal) {
        UserInfo user = service.getUser(principal.getName());
        List<TransactionInfo> transactionInfos = transactionService.findByOwner(user.getId());

        model.addAttribute("userInfo", user);
        model.addAttribute("transactionInfos", transactionInfos);
        return "privateOffice";
    }

}


