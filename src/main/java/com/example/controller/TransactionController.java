package com.example.controller;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.entity.TransactionInfo;
import com.example.entity.UserInfo;
import com.example.service.TransactionService;
import com.example.service.UserService;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private UserService userService;

    @GetMapping("/transactions")
    List<TransactionInfo> getTransactions(Integer ownerId) {
        return transactionService.findByOwner(ownerId);
    }

    @PostMapping("/transactions")
    void sendTransactions(@RequestBody TransactionInfo transactionInfo) {
        transactionService.saveTransaction(transactionInfo);
        UserInfo byId = userService.findById(Integer.parseInt(transactionInfo.getOwnerId()));
        if (Objects.nonNull(byId)) {
            transactionService.sendAmountTransaction(transactionInfo.getAmount().toString(), byId.getPhone());
        }
    }

    @GetMapping("/getTotalTransactionAmount/{phone}")
    int getTotalTransactionAmount(@PathVariable String phone) {
        return transactionService.getTotalTransactionAmount(phone);
    }

}
