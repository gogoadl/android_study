package com.hyeonwoo.java_background.repository;

import android.os.Handler;

import com.hyeonwoo.java_background.Result;

import java.util.concurrent.Executor;

/*
    숫자를 제공하는 레포지토리
    UI를 갱신하기 위해서 executor와 handler 객체를 필요로 한다.

 */
public class NumberRepository {
    private final Executor executor; // final이 없으면 객체가 null인 상황이 발생할 수 있다.
    private final Handler resultHandler;

    public NumberRepository(Executor executor, Handler resultHandler) {
        this.executor = executor;
        this.resultHandler = resultHandler;
    }
    // 숫자를 발생시키는 메소드
    public void longTask(RepositoryCallback<Integer> callback) {
        executor.execute(new Runnable() { // 비동기로 실행함함
           @Override
            public void run() {
                try {
                    // background
                    int num = 0;
                    for (int i = 0; i < 100; i++) {
                        num++;
                        // UI 갱신을 위해서 콜백
                        Result<Integer> result = new Result.Success<>(num);
                        notifyResult(result, callback);
                        Thread.sleep(100);
                    }
                } catch (Exception e) {
                    Result<Integer> result = new Result.Error<>(e);
                    notifyResult(result, callback);
                    e.printStackTrace();
                }
            }
        });
    }
    private void notifyResult(
        final Result<Integer> result,
        final RepositoryCallback<Integer> callback) {
            resultHandler.post(new Runnable() { // MainThread에서 UI 업데이트를 위해서
                @Override
                public void run() {
                    callback.onComplete(result);
                }
            });
        }
    }
