package com.hyeonwoo.room_exam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.room.Room;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.hyeonwoo.room_exam.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    // 데이터바인딩은 xml에 데이터를 넘길 수 있다.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setLifecycleOwner(this);

        MainViewModel viewModel = ViewModelProviders.of(this).get(MainViewModel.class); // ViewModel 객체 가져오기

        binding.setViewModel(viewModel);

        // 버튼 클릭시 DB에 Insert
        binding.addButton.setOnClickListener(v -> {
            viewModel.insert(new Todo(binding.todoEdit.getText().toString()));
        });

    }

}