package com.acgp.notification_api.provider;

import com.acgp.notification_api.enums.ChannelType;
import com.acgp.notification_api.model.Notification;
import org.springframework.stereotype.Component;

@Component
public class SmsNotificationProvider implements NotificationProvider{

    @Override
    public ChannelType getChannel() {
        return null;
    }

    @Override
    public void send(Notification notification) {
        System.out.println("Enviando notificación por vía SMS al usuario: " + notification.getUserId());

    }
}
