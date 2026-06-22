package com.acgp.notification_api.provider;

import com.acgp.notification_api.enums.ChannelType;
import com.acgp.notification_api.model.Notification;
import org.springframework.stereotype.Component;

@Component
public interface NotificationProvider {

    ChannelType getChannel();

    void send(Notification notification);
}
