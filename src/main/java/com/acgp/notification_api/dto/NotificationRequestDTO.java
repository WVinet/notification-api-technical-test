package com.acgp.notification_api.dto;

import com.acgp.notification_api.enums.ChannelType;
import lombok.Data;

import java.util.UUID;

@Data
public class NotificationRequestDTO {
    private UUID userId;
    private String message;
    private ChannelType channel;
}
