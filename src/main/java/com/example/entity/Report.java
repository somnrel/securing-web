package com.example.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "Reports")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reportID;

    @ManyToOne
    @JoinColumn(name = "changeRequestID", nullable = false)
    private ChangeRequest changeRequest;

    @ManyToOne
    @JoinColumn(name = "generatedBy", nullable = false)
    private UserInfo generatedBy;

    @Column(name = "reportDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reportDate;

    @Column(columnDefinition = "TEXT")
    private String content;

    // Getters and Setters  
} 