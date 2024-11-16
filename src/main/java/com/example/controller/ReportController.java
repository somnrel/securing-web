package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReportController {

    @GetMapping("/reports")
    public String getReports(Model model) {
        // Пример данных для отчета; в реальности будут извлекаться из базы данных  
        int totalChanges = 100; // Общее количество изменений  
        int completedChanges = 70; // Количество успешно завершенных изменений  
        int rejectedChanges = 20; // Количество отклоненных изменений  
        int incomingRequests = 30; // Количество входящих запросов  

        double successRate = (double) completedChanges / totalChanges * 100;
        double rejectionRate = (double) rejectedChanges / totalChanges * 100;

        // Передача данных в модель  
        model.addAttribute("successRate", successRate);
        model.addAttribute("rejectionRate", rejectionRate);
        model.addAttribute("incomingRequests", incomingRequests);

        return "reports"; // Имя вашего шаблона  
    }
}  