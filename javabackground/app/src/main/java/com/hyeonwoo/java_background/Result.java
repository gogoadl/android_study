package com.hyeonwoo.java_background;


/*
추상클래스 Result를 생성한다. 이 Result에는 어떤 타입도 들어올 수 있다.

 */
public abstract class Result<T> {
    private Result() {} // 생성자를 사용하지 못하도록 함

    public static final class Success<T> extends  Result<T> {
        public T data;

        public Success(T data) { this.data = data; }
    }
    public static final class Error<T> extends Result<T> {
        public Exception exception;

        public Error(Exception exception) { this.exception = exception; }
    }

}
