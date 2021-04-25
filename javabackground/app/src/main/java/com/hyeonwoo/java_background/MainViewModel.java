package com.hyeonwoo.java_background;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.hyeonwoo.java_background.repository.NumberRepository;
import com.hyeonwoo.java_background.repository.RepositoryCallback;

public class MainViewModel extends AndroidViewModel {
    private final NumberRepository repository;


    public MainViewModel(@NonNull Application application) {
        super(application);
        repository = new NumberRepository(
                ((App) application).executorService,
                ((App) application).mainThreadHandler);
    }

    public void longTask(RepositoryCallback<Integer> callback) {
        repository.longTask(callback);
    }
}
