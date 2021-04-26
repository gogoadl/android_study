package com.hyeonwoo.java_background.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.hyeonwoo.java_background.MainViewModel;
import com.hyeonwoo.java_background.R;
import com.hyeonwoo.java_background.Result;
import com.hyeonwoo.java_background.databinding.FragmentExecutorBinding;
import com.hyeonwoo.java_background.repository.RepositoryCallback;

public class ExecutorFragment extends Fragment {
    private static final String TAG = ExecutorFragment.class.getSimpleName();
    private MainViewModel viewModel;
    private FragmentExecutorBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_executor, container, false);
        binding = FragmentExecutorBinding.bind(view);
        return binding.getRoot(); // 여기서 return한 View 객체는 onViewCreated에서 받을 수 있다.
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(requireActivity(),
                new ViewModelProvider.AndroidViewModelFactory(requireActivity().getApplication()))
                .get(MainViewModel.class);

        // Fragment의 Lifecycle 동안에만 Callback으로 사용
        viewModel.progressLiveData.observe(getViewLifecycleOwner(), progress -> binding.progress.setProgress(progress));

        binding.button.setOnClickListener(v -> viewModel.longTask());
    }
}