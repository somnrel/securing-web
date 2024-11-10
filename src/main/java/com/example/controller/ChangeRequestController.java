package com.example.controller;

import com.example.entity.ChangeRequest;
import com.example.repository.ChangeRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ChangeRequestController {

    @Autowired
    private ChangeRequestRepository changeRequestRepository;

    @RequestMapping("/")
    public String showForm() {
        return "changeRequestForm"; // ваше имя HTML-шаблона
    }

    @PostMapping("/submitChangeRequest")
    public String submitChangeRequest(@RequestParam String title,
                                      @RequestParam String description,
                                      @RequestParam String reason,
                                      @RequestParam String priority,
                                      @RequestParam String dueDate,
                                      @RequestParam String responsible) {
        // Логика обработки запроса на изменение
        // Например, сохранение в базе данных
        return "redirect:/success"; // после успешной обработки перенаправление на страницу успеха
    }

    @GetMapping("/change-request/{id}")
    public String viewChangeRequest(@PathVariable Integer id, Model model) {
        ChangeRequest changeRequest = changeRequestRepository.findById(id).orElse(null);
        model.addAttribute("changeRequest", changeRequest);
        return "viewRequestChange"; // Имя Thymeleaf шаблона
    }

}
