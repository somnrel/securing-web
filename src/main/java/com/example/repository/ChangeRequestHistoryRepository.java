package com.example.repository;

import com.example.entity.ChangeRequestHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChangeRequestHistoryRepository extends JpaRepository<ChangeRequestHistory, Integer> {
    List<ChangeRequestHistory> findByChangeRequest_Id(Integer id); // Убедитесь, что здесь правильный метод
}