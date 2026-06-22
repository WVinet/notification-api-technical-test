package com.acgp.notification_api.service;

import com.acgp.notification_api.dto.NotificationRequestDTO;
import com.acgp.notification_api.storage.NotificationStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationStorage storage;

    public void createNotification(NotificationRequestDTO requestDTO){

    }
}
