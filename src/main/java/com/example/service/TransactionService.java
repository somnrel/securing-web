package com.example.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.entity.TransactionInfo;
import com.example.repository.TransactionRepository;

@Service
public class TransactionService {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private TransactionRepository repository;

    public List<TransactionInfo> findByOwner(Integer ownerId){
        return repository.findByOwnerId(ownerId);
    }

    public int getTotalTransactionAmount(String phone){
        return repository.getTotalTransactionAmount(phone);
    }

    public void saveTransaction(TransactionInfo transactionInfo) {
        repository.save(transactionInfo);
    }

    public void sendAmountTransaction(String amount, String phone) {
        String url = "http://localhost:8090/sendAmount";
        Map<String, String> map = new HashMap<>();
        map.put("amount", amount);
        map.put("phone", phone);
        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(map);
        restTemplate().postForObject(url, requestEntity, String.class);
    }

}
