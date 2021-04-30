package com.hyeonwoo.java_background.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;

import androidx.core.app.NotificationCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.work.Data;
import androidx.work.ListenableWorker;

import com.hyeonwoo.java_background.App;
import com.hyeonwoo.java_background.R;
import com.hyeonwoo.java_background.Result;
import com.hyeonwoo.java_background.repository.NumberRepository;

public class MyService extends Service {
    private NumberRepository repository;

    public MutableLiveData<Integer> progressLiveData = new MutableLiveData<>(0);

    private static final String CHANNEL_ID = "Job Channel";

    private NotificationManager notificationManager;

    public MyService() {

        repository = new NumberRepository(
                ((App) getApplication()).executorService,
                ((App) getApplication()).mainThreadHandler
        );
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        createNotificationChannel();

        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Foreground Service")
                .setProgress(100, 0, false)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .build();

        startForeground(2000, notification);

        repository.longTask(result -> {
            if (result instanceof Result.Success) {
                progressLiveData.postValue(((Result.Success<Integer>) result).data);
                showNotification(((Result.Success<Integer>) result).data);
//                    binding.progress.setProgress(((Result.Success<Integer>) result).data);
            } else if (result instanceof Result.Error){
//                    Toast.makeText(TAG, ((Result.Error<Integer>) result).exception.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
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
                .setContentTitle("Foreground Service")
                .setProgress(100, progress, false)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .build();

        notificationManager.notify(2000, notification);
    }
}