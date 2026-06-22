package com.acgp.notification_api.service;

import com.acgp.notification_api.dto.NotificationRequestDTO;
import com.acgp.notification_api.model.Notification;


import java.util.List;

public interface NotificationService {


    Notification createNotification(NotificationRequestDTO requestDTO);

    List<Notification> getNotifications();
}
