package com.example.hi.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.hi.R;
import com.example.hi.adapter.TaskAdapter;
import com.example.hi.databinding.FragmentHomeBinding;
import com.example.hi.model.TaskModel;
import com.example.hi.utils.App;
import com.example.hi.utils.Constants;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;


public class HomeFragment extends Fragment implements TaskAdapter.Listener{
    FragmentHomeBinding binding;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.addFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(requireView()).navigate(R.id.createTaskFragment);
            }

        });
        initRecycler();
        if (getArguments() != null){
            String s = getArguments().getString(Constants.USER_TASK);
            binding.txtTitle.setText(s);
        }

    }

    private void initRecycler() {
        App.getInstance().getDatabase().taskDao().getAll().observe(getViewLifecycleOwner(),taskModels -> {
            TaskAdapter taskAdapter = new TaskAdapter((ArrayList<TaskModel>) taskModels, this);
            binding.taskRecycler.setAdapter(taskAdapter);
        });

    }



    private void getText(String  userTask,int abobus){

    }


    @Override
    public void itemLongClick(TaskModel taskModel) {
        new AlertDialog.Builder(requireContext()).setTitle("предупреждение").setMessage("g").setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                App.getInstance().getDatabase().taskDao().delete(taskModel);
            }
        })
        .setNegativeButton(android.R.string.no, null).show();
    }

    @Override
    public void itemClick(TaskModel model) {

    }
}