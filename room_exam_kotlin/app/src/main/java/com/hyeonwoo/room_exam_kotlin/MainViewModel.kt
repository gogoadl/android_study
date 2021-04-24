package com.hyeonwoo.room_exam_kotlin

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.room.Room

class MainViewModel(application: Application): AndroidViewModel(application) {
    private val db = Room.databaseBuilder(application, AppDatabase::class.java, "tood-db").build()

    var todos : LiveData<List<Todo>>

    init {
        todos = getAll()
    }

    fun getAll(): LiveData<List<Todo>> {
        return db.todoDao().getAll();
    }
    /*
     suspend 한정자는 해당 함수가 무조건 코루틴 안에서 처리되어야 한다는 뜻으로,
     코루틴 스코프를 벗어나면 컴파일러에서 에러로 처리한다.
     */
    suspend fun insert(todo : Todo) {
        db.todoDao().insert(todo)
    }


}