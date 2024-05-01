package com.Final.Back.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class NotificationController {

    @Autowired
    private NotificationService notificationService; // Implement this service

    @MessageMapping("/notify")
    @SendTo("/topic/notifications")
    public Notification notify(Notification notification) {
        return notificationService.incrementNotification(notification); // Implement this method
    }
}