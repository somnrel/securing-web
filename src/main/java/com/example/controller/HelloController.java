package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
public class HelloController {
    @GetMapping("/test")
    public String handle() {
        return "Hello WebFlux";
    }
}
