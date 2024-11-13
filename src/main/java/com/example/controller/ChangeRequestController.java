package com.example.controller;

import com.example.entity.ChangeRequest;
import com.example.entity.ChangeRequestHistory;
import com.example.repository.ChangeRequestHistoryRepository;
import com.example.repository.ChangeRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/change-requests")
public class ChangeRequestController {

    @Autowired
    private ChangeRequestRepository changeRequestRepository;

    @Autowired
    private ChangeRequestHistoryRepository changeRequestHistoryRepository;

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

    @GetMapping("/{id}")
    public String getChangeRequestDetails(@PathVariable Integer id, Model model) {
        ChangeRequest changeRequest = changeRequestRepository.findById(id).orElse(null);
        List<ChangeRequestHistory> history = changeRequestHistoryRepository.findByChangeRequest_Id(id);
        model.addAttribute("changeRequest", changeRequest);
        model.addAttribute("history", history);
        return "viewRequestChange"; // Название вашего шаблона
    }

}
