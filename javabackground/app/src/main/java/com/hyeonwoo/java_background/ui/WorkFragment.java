package com.hyeonwoo.java_background.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hyeonwoo.java_background.R;
import com.hyeonwoo.java_background.WorkManagerViewModel;
import com.hyeonwoo.java_background.databinding.FragmentWorkBinding;
import com.hyeonwoo.java_background.worker.MyWorker;

public class WorkFragment extends Fragment {

    private FragmentWorkBinding binding;

    private WorkManagerViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_work, container, false);
        binding = FragmentWorkBinding.bind(view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(requireActivity()).get(WorkManagerViewModel.class); // requireActivity를 넣는 이유는 생명주기를 Activity에 의존하도록 하기위해

        viewModel.progressLiveData.observe(getViewLifecycleOwner(), workInfo ->
                binding.progress.setProgress(workInfo.getProgress().getInt("progress", 0)));

//        OneTimeWorkRequest request = new OneTimeWorkRequest
//                .Builder(MyWorker.class)
//                .build();

        binding.button.setOnClickListener(v -> {
            viewModel.startLongTask();
        });
    }
}