package com.example.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entity.TransactionInfo;
import com.example.repository.TransactionRepository;
import com.example.repository.UserInfoRepository;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository repository;

    public List<TransactionInfo> findByOwner(Integer ownerId){
        return repository.findByOwnerId(ownerId);
    }

    public void saveTransaction(TransactionInfo transactionInfo) {
        repository.save(transactionInfo);
    }
}
