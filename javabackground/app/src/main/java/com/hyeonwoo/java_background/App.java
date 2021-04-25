package com.hyeonwoo.java_background;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.core.os.HandlerCompat;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App extends Application {
    // 사용가능한 프로세스의 갯수를 얻어온다
    private static int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();
    // 동시에 NUMBER_OF_CORES 만큼의 쓰레드를 사용한다.
    ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_CORES);
    // 메인쓰레드를 반복시켜주는 객체 - 새로운 UI 갱신이 들어왔을 때 실행해준다.
    Handler mainThreadHandler = HandlerCompat.createAsync(Looper.getMainLooper());

}
