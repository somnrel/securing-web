package com.example.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.entity.UserInfo;
import com.example.repository.UserInfoRepository;

@Service
public class UserService {


    @Autowired
    private UserInfoRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void addUser(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        repository.save(userInfo);
    }

    public UserInfo findByPhone(String phone) {
        Optional<UserInfo> userInfo = repository.findByPhone(phone);
        return userInfo.orElse(null);
    }

    public UserInfo findById(Integer id) {
        Optional<UserInfo> userInfo = repository.findById(id);
        return userInfo.orElse(null);
    }

    public boolean isUserExists(String phone) {
        return repository.existsByPhone(phone);
    }
}
