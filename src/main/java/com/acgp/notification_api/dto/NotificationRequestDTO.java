package com.acgp.notification_api.dto;

import com.acgp.notification_api.enums.ChannelType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class NotificationRequestDTO {
    @NotBlank(message = "userId is required")
    private String userId;

    @NotBlank(message = "message is required")
    private String message;

    @NotNull(message = "channel is required")
    private ChannelType channelType;
}
