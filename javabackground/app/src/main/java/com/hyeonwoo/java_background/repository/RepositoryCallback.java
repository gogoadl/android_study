package com.hyeonwoo.java_background.repository;

import com.hyeonwoo.java_background.Result;

public interface RepositoryCallback<T> {
    void onComplete(Result<T> result);
}