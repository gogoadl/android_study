package com.hyeonwoo.room_exam;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Todo.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase { // Database 객체 생성
    public abstract TodoDao todoDao();
}
