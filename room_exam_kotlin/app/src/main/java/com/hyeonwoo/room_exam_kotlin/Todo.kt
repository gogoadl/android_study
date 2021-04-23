package com.hyeonwoo.room_exam_kotlin

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo(var title : String) // data class로 생성 시 getter, setter 정의를 하지 않아도 된다.
{
    @PrimaryKey(autoGenerate = true) var id: Int = 0 // 자동으로 생성되는 값으로 생성자에 포함하지 않아도 된다.
}