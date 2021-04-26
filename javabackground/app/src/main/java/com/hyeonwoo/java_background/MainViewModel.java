package com.hyeonwoo.java_background;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.hyeonwoo.java_background.repository.NumberRepository;
import com.hyeonwoo.java_background.repository.RepositoryCallback;

public class MainViewModel extends AndroidViewModel {
    private final NumberRepository repository;
    public MutableLiveData<Integer> progressLiveData = new MutableLiveData<>(0);

    public MainViewModel(@NonNull Application application) {
        super(application);
        repository = new NumberRepository(
                ((App) application).executorService,
                ((App) application).mainThreadHandler);
    }

    public void longTask() {
        repository.longTask(result -> {
                if (result instanceof Result.Success) {
                    progressLiveData.postValue(((Result.Success<Integer>) result).data);
//                    binding.progress.setProgress(((Result.Success<Integer>) result).data);
                } else if (result instanceof Result.Error){
//                    Toast.makeText(TAG, ((Result.Error<Integer>) result).exception.getMessage(), Toast.LENGTH_SHORT).show();
                }
        });
    }
}
