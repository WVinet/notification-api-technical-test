package com.acgp.notification_api.model;

import com.acgp.notification_api.enums.ChannelType;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Notification {

    private String userId;
    private String message;
    private ChannelType channelType;

}
