package com.acgp.notification_api.service;

import com.acgp.notification_api.dto.NotificationRequestDTO;
import com.acgp.notification_api.model.Notification;
import com.acgp.notification_api.provider.NotificationProvider;
import com.acgp.notification_api.storage.NotificationStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl {

    private final NotificationStorage storage;
    private final List<NotificationProvider> providers;

    public Notification createNotification(NotificationRequestDTO requestDTO){
        Notification notification = new Notification();
        notification.setUserId(requestDTO.getUserId());
        notification.setMessage(requestDTO.getMessage());
        notification.setChannelType(requestDTO.getChannelType());
        NotificationProvider provider = providers.stream()
                .filter(p -> p.getChannel() == notification.getChannelType())
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unsupported channel"));
        provider.send(notification);
        storage.save(notification);
        return notification;
    }

    public List<Notification> getNotifications(){
        return storage.findAll();
    }
}
