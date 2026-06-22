package com.acgp.notification_api.controller;

import com.acgp.notification_api.dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/notification/")
public class NotificationController {

    @GetMapping
    public ResponseEntity<ApiResponse<?>> findAll(){

    }

    @PostMapping
    public ResponseEntity<ApiResponse<?>> createNotification(){

    }
}
