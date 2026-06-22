package com.acgp.notification_api.provider;

import com.acgp.notification_api.enums.ChannelType;
import com.acgp.notification_api.model.Notification;
import org.springframework.stereotype.Component;

@Component
public class EmailNotificationProvider implements NotificationProvider {


    @Override
    public ChannelType getChannel() {
        return ChannelType.EMAIL;
    }

    @Override
    public void send(Notification notification) {
        System.out.println("Enviando notificación por vía EMAIL al usuario: " + notification.getUserId());

    }
}
