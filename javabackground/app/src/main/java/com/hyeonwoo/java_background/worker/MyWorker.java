package com.hyeonwoo.java_background.worker;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.hyeonwoo.java_background.R;

public class MyWorker extends Worker {
    // Jobservice와 다른점은 Service를 등록하지 않고 Service의 기능을 사용할 수 있다.
    // Jobservice보다 UI에 그리기가 비교적 쉽다.
    private static final String CHANNEL_ID = "Job Channel";

    private NotificationManager notificationManager;

    public MyWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        createNotificationChannel();

    }

    @NonNull
    @Override
    public Result doWork() {
        notificationManager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);

        createNotificationChannel();

        try {
            int num = 0;
            for (int i = 0; i < 100; i++) {
                num++;

                Data data = new Data.Builder().putInt("progress", num).build();
                setProgressAsync(data);

                // UI 갱신을 위해서 콜백
                showNotification(num);
                Thread.sleep(100);
            }
        } catch (Exception e) {
            return Result.failure();
        }

        return Result.success();
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
        Notification notification = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("WorkManager long task")
                .setProgress(100, progress, false)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .build();

        notificationManager.notify(3, notification);
    }
}
