package com.example.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "KPIs")
public class KPI {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer kpiID;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    private Double weight;
    private Double goal;

    // Getters and Setters  
}  