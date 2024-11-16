package com.example.entity.enumVar;

import lombok.Getter;

@Getter
public enum ActionType {
    DELEGATION("Делегирование"),
    COMMENT("Комментарий"),
    STATUS_CHANGE("Изменение статуса");

    private final String displayName;

    ActionType(String displayName) {
        this.displayName = displayName;
    }

}