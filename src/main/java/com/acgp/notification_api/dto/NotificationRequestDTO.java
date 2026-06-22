package com.acgp.notification_api.dto;

import com.acgp.notification_api.enums.ChannelType;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class NotificationRequestDTO {
    @NotNull
    private Integer userId;
    @NotNull
    private String message;
    @NotNull
    private ChannelType channelType;
}
