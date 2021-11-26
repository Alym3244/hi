package com.example.hi.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.workhomee1.databinding.FragmentCreateTaskBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


public class CreateTaskFragment extends BottomSheetDialogFragment {

    FragmentCreateTaskBinding binding;
    String userTask;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentCreateTaskBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @org.jetbrains.annotations.NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userTask = binding.taskEd.getText().toString();
               // Bundle bundle = new Bundle();
               // bundle.putString(Constants.USER_TASK, userTask);
               // Navigation.findNavController(requireView()).navigate(R.id.homeFragment,bundle);
               // Toast.makeText(getContext(), "" +  bundle.getString(Constants.USER_TASK, userTask), Toast.LENGTH_SHORT).show();
            }
        });

    }

}