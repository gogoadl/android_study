package com.hyeonwoo.java_background.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
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
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(requireActivity(),
                new ViewModelProvider.AndroidViewModelFactory(requireActivity().getApplication()))
                .get(MainViewModel.class);
        int number = 0;
        binding.button.setOnClickListener(v ->
                viewModel.longTask(result -> {
                    if (result instanceof Result.Success) {
                        binding.progress.setProgress(((Result.Success<Integer>) result).data);
                    } else if (result instanceof Result.Error){
//                        Toast.makeText(TAG, ((Result.Error<Integer>) result).exception.getMessage(), Toast.LENGTH_SHORT).show();
                    }
        }));
    }
}