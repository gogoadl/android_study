package com.hyeonwoo.java_background.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hyeonwoo.java_background.R;
import com.hyeonwoo.java_background.databinding.FragmentForegroundServiceBinding;
import com.hyeonwoo.java_background.service.MyService;

public class ForegroundServiceFragment extends Fragment {
    private FragmentForegroundServiceBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_foreground_service, container, false);
        binding = FragmentForegroundServiceBinding.bind(view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.button.setOnClickListener(v -> {
            ContextCompat.startForegroundService(
                    requireContext(),
                    new Intent(requireContext(), MyService.class));
        });
    }
}