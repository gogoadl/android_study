package com.hyeonwoo.java_background.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.core.app.JobIntentService;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;

import com.hyeonwoo.java_background.R;

public class JobService extends JobIntentService {

    private static final String CHANNEL_ID = "Job Channel";

    private NotificationManager notificationManager;

    public static void enqueueWork(@NonNull Context context, @NonNull Intent intent) {
        JobIntentService.enqueueWork(context, JobService.class, 1000, intent);
    }

    @Override
    protected void onHandleWork(@NonNull Intent intent) {
        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        createNotificationChannel();
        try {
            int num = 0;
            for (int i = 0; i < 100; i++) {
                num++;
                // UI 갱신을 위해서 콜백
                showNotification(num);
                Thread.sleep(100);
            }
        } catch (Exception e) {

        }
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Job channel";
            String description = "Job channel";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);

            notificationManager.createNotificationChannel(channel);
        }
    }

    private void showNotification(int progress) {
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Job Service")
                .setProgress(100, progress, false)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .build();

        notificationManager.notify(2, notification);
    }
}
