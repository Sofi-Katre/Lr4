package com.example.lr4;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import androidx.core.app.NotificationCompat;

public class MyPushNotification {
    private static final String CHANNEL_ID = "Base channel";
    private static final String CHANNEL_DESCRIPTION = "it's a base channel";

    private final NotificationManager notificationManager;
    private final Context context;

    public MyPushNotification(Context context, NotificationManager manager) {
        notificationManager = manager;
        this.context = context;
        createNotificationChannel();
    }

    public void sendNotify(String title, String text) {
        // Генерируем уникальный ID на основе текущего времени.
        // Это обеспечит, что новые уведомления не будут заменять старые.
        int uniqueId = (int) System.currentTimeMillis();

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setContentTitle(title)
                .setContentText(text)
                .setSmallIcon(R.drawable.ic_notification) // Иконка для уведомлений
                .setPriority(NotificationCompat.PRIORITY_DEFAULT); // Установим приоритет

        // Отправляем уведомление с уникальным ID
        notificationManager.notify(uniqueId, builder.build());
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, CHANNEL_ID, importance);
            channel.setDescription(CHANNEL_DESCRIPTION);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
