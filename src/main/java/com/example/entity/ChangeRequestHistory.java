package com.example.entity;

import com.example.entity.enumVar.ActionType;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@ToString // Добавьте это, если у вас его нет
@Table(name = "ChangeRequestHistory")
public class ChangeRequestHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "changeRequestID", nullable = false)
    private ChangeRequest changeRequest;

    @Enumerated(EnumType.STRING)
    private ActionType action; // Используем перечисление для действий

    @ManyToOne
    @JoinColumn(name = "userID", nullable = false)
    private UserInfo user;

    @Column(columnDefinition = "TEXT")
    private String comment; // Комментарий с текстовым полем

    @Column(name = "date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    // В этом случае, можно оставить геттеры и сеттеры, предоставляемые Lombok
}