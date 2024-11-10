package com.example.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "ChangeKPI")
public class ChangeKPI {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer changeKPIID;

    @ManyToOne
    @JoinColumn(name = "changeImplID", nullable = false)
    private ChangeImpl changeImpl;

    @ManyToOne
    @JoinColumn(name = "kpiID", nullable = false)
    private KPI kpi;

    private Double actualValue;

    @Column(name = "evaluationDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date evaluationDate;

    // Getters and Setters  
}  