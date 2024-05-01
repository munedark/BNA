package com.Final.Back.Configuration;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    private Long notificationCount = 0L;

    public Notification incrementNotification(Notification notification) {
// Increment and update notification details accordingly
        notificationCount++;
        notification.setId(notificationCount);
// Assuming the message is set by the caller
        return notification;
    }
}