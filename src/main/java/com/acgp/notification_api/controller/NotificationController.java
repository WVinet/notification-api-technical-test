package com.acgp.notification_api.controller;

import com.acgp.notification_api.dto.ApiResponseDTO;
import com.acgp.notification_api.dto.NotificationRequestDTO;
import com.acgp.notification_api.dto.NotificationResponseDTO;
import com.acgp.notification_api.model.Notification;
import com.acgp.notification_api.service.NotificationService;
import com.acgp.notification_api.service.NotificationServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationServiceImpl notificationService;

    @GetMapping
    public ResponseEntity<ApiResponseDTO<List<Notification>>> findAll(){
        List<Notification> notifications = notificationService.getNotifications();

        ApiResponseDTO<List<Notification>> response =
                new ApiResponseDTO<>(
                        "SUCCESS",
                        "Lista de notificaciones traida correctamente",
                        notifications);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponseDTO<Notification>> createNotification(
            @Valid @RequestBody NotificationRequestDTO requestDTO){
        Notification notification = notificationService.createNotification(requestDTO);

        ApiResponseDTO<Notification> response =
                new ApiResponseDTO<>(
                        "SUCCESS",
                        "Notificación enviada correctamente",
                        notification);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);

    }
}
