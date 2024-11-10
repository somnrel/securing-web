package com.example.entity;

import com.example.entity.enumVar.Priority;
import com.example.entity.enumVar.Status;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "ChangeRequests")
public class ChangeRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer changeRequestID;

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

    // Getters and Setters  
}  