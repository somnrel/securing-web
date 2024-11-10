package com.example.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "ChangeImply")
public class ChangeImpl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer changeImplID;

    @ManyToOne
    @JoinColumn(name = "changeRequestID", nullable = false)
    private ChangeRequest changeRequest;

    @ManyToOne
    @JoinColumn(name = "implementedBy", nullable = false)
    private UserInfo implementedBy;

    @Column(name = "implementationDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date implementationDate;

    @Column(columnDefinition = "TEXT")
    private String results;

    // Getters and Setters  
}  