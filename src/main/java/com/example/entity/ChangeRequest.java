package com.example.entity;

import com.example.entity.enumVar.Priority;
import com.example.entity.enumVar.Status;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "ChangeRequests")
@ToString // Добавьте это, если у вас его нет
public class ChangeRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // Измените с changeRequestID на id

    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    @JoinColumn(name = "requestedBy", nullable = false)
    private UserInfo requestedBy;

    @Column(name = "requestDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date requestDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @OneToMany(mappedBy = "changeRequest", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude // Исключите это поле из toString
    private List<ChangeRequestHistory> history = new ArrayList<>();

    // Getters and Setters  
}  