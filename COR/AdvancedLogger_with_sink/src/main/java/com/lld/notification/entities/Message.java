package com.lld.notification.entities;

import com.lld.notification.entities.enums.LOG_LEVEL;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class Message {

    LocalDateTime dateTime;

    LOG_LEVEL log_level;

    String message;
}
