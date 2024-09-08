package com.example.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.entity.TransactionInfo;
import com.example.service.TransactionService;
import com.example.service.UserService;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService service;

    @GetMapping("/transactions")
    List<TransactionInfo> getTransactions(Integer ownerId) {
        return service.findByOwner(ownerId);
    }

    @PostMapping("/transactions")
    void sendTransactions(@RequestBody TransactionInfo transactionInfo) {
        service.saveTransaction(transactionInfo);
    }

}
