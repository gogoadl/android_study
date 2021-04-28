package com.hyeonwoo.java_background;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import com.hyeonwoo.java_background.worker.MyWorker;

public class WorkManagerViewModel extends AndroidViewModel {
    private WorkManager workManager;

    private OneTimeWorkRequest request = new OneTimeWorkRequest
            .Builder(MyWorker.class)
            .build();

    public LiveData<WorkInfo> progressLiveData;

    public WorkManagerViewModel(@NonNull Application application) {
        super(application);

        workManager = WorkManager.getInstance(application.getApplicationContext());
        progressLiveData = workManager.getWorkInfoByIdLiveData(request.getId());

    }
    public void startLongTask() {
        workManager.enqueue(request);
    }
}
