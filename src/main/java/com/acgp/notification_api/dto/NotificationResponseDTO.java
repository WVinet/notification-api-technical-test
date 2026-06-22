package com.acgp.notification_api.dto;

import com.acgp.notification_api.enums.ChannelType;
import lombok.Data;

@Data
public class NotificationResponseDTO {

    private Integer userId;
    private String message;
    private ChannelType channelType;
}
