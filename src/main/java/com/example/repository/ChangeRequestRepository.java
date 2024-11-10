package com.example.repository;

import com.example.entity.ChangeRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChangeRequestRepository extends JpaRepository<ChangeRequest, Integer> {}
