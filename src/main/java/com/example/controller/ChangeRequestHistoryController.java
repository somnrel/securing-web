package com.example.controller;

import com.example.entity.ChangeRequest;
import com.example.entity.ChangeRequestHistory;
import com.example.entity.UserInfo;
import com.example.entity.enumVar.ActionType;
import com.example.repository.ChangeRequestHistoryRepository;
import com.example.repository.ChangeRequestRepository;
import com.example.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/change-request-history")
public class ChangeRequestHistoryController {

    @Autowired
    private ChangeRequestHistoryRepository changeRequestHistoryRepository;

    @Autowired
    private ChangeRequestRepository changeRequestRepository;

    @Autowired
    private UserInfoRepository userInfoRepository;

    // Получение истории изменений для конкретного запроса на изменение
    @GetMapping("/{changeRequestId}")
    public String getHistoryForChangeRequest(@PathVariable Integer changeRequestId, Model model) {
        List<ChangeRequestHistory> historyList = changeRequestHistoryRepository.findByChangeRequest_Id(changeRequestId);
        model.addAttribute("historyList", historyList);
        model.addAttribute("changeRequestId", changeRequestId);
        return "changeRequestHistory"; // Название вашего шаблона
    }

    // Форма для добавления новой записи истории изменений
    @GetMapping("/add/{changeRequestId}")
    public String showAddHistoryForm(@PathVariable Integer changeRequestId, Model model) {
        ChangeRequest changeRequest = changeRequestRepository.findById(changeRequestId).orElse(null);
        if (changeRequest == null) {
            return "redirect:/error"; // Обработка ошибки, если запрос не найден
        }

        model.addAttribute("changeRequest", changeRequest);
        model.addAttribute("actionTypes", ActionType.values());
        model.addAttribute("newHistoryItem", new ChangeRequestHistory());
        return "addChangeRequestHistory"; // Название вашего шаблона для добавления записи
    }

    // Обработка добавления новой записи истории изменений
    @PostMapping("/add")
    public String addChangeRequestHistory(@ModelAttribute("newHistoryItem") ChangeRequestHistory historyItem,
                                          @RequestParam("changeRequestId") Integer changeRequestId,
                                          @RequestParam("userId") Integer userId) {
        ChangeRequest changeRequest = changeRequestRepository.findById(changeRequestId).orElse(null);
        UserInfo user = userInfoRepository.findById(userId).orElse(null);

        if (changeRequest != null && user != null) {
            historyItem.setChangeRequest(changeRequest);
            historyItem.setUser(user);
            historyItem.setDate(new Date());

            changeRequestHistoryRepository.save(historyItem);
        }

        return "redirect:/change-request-history/" + changeRequestId; // Перенаправление обратно к истории изменений
    }

    // Удаление записи о истории изменений
    @PostMapping("/delete/{id}")
    public String deleteChangeRequestHistory(@PathVariable Integer id) {
        changeRequestHistoryRepository.deleteById(id);
        return "redirect:/change-request-history"; // Перенаправление на страницу истории (или другую)
    }
}