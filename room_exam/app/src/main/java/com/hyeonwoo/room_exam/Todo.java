package com.hyeonwoo.room_exam;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity // Room의 Entity로 사용
public class Todo {
    @PrimaryKey(autoGenerate = true) // 1씩 증가하는 id값으로 사용
    private int id;
    private String title;

    // alt + insert를 통해 간단하게 getter, setter, constructor, tostring 을 생성할 수 있다.
    public Todo(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
