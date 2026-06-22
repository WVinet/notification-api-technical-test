package com.acgp.notification_api.storage;

import com.acgp.notification_api.model.Notification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NotificationStorage {

    private final List<Notification> notifications = new ArrayList<>();

    public void save(Notification notification){
        notifications.add(notification);
    }

    public List<Notification> findAll(){
        return new ArrayList<>(notifications);
    }
}
