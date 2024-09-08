package com.example.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.entity.TransactionInfo;
import com.example.entity.UserInfo;

public interface TransactionRepository extends JpaRepository<TransactionInfo, Integer> {

    @Query(value = "  SELECT CASE typeOperation WHEN 'ADD' THEN 'Начисление' WHEN 'SUB' THEN 'Списание' END AS typeOperation, amount, dateTransaction, ownerId, id  FROM transaction t where t.ownerId = :ownerId", nativeQuery = true)
    List<TransactionInfo> findByOwnerId(Integer ownerId);

}
