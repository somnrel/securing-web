package com.example.entity.enumVar;

import lombok.Getter;

@Getter
public enum Status {
    PENDING("В ожидании"),
    IN_PROGRESS("В процессе"),
    COMPLETED("Завершено"),
    REJECTED("Отклонено");

    private final String displayName;

    Status(String displayName) {
        this.displayName = displayName;
    }

}