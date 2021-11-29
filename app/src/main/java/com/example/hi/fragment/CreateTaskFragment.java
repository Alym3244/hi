package com.example.hi.fragment;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.DatePicker;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.hi.R;
import com.example.hi.databinding.FragmentCreateTaskBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.Calendar;


public class CreateTaskFragment extends BottomSheetDialogFragment implements DatePickerDialog.OnDateSetListener {
    private int startYear;
    private int starthMonth;
    private int startDay;
    String repeatCount;
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
        initClickers();
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

    private void initClickers() {   
        binding.addBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            userTask = binding.taskEd.getText().toString();
            passModelToHomeFragment();
            // Bundle bundle = new Bundle();
            // bundle.putString(Constants.USER_TASK, userTask);
            // Navigation.findNavController(requireView()).navigate(R.id.homeFragment,bundle);
            // Toast.makeText(getContext(), "" +  bundle.getString(Constants.USER_TASK, userTask), Toast.LENGTH_SHORT).show();
        }
    });
        binding.dateTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
        binding.repeatTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRepeatDialog();
            }
        });
    }


    private void showRepeatDialog() {
        LayoutInflater inflater = LayoutInflater.from(requireContext());
        @SuppressLint("InflateParams") View view = inflater.inflate(R.layout.repeat_dialog, null);
        Dialog alertDialog = new Dialog(requireContext());
        alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        alertDialog.setContentView(view);
        alertDialog.show();
        RadioButton neverBtn = alertDialog.findViewById(R.id.never);
        neverBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                repeatCount = neverBtn.getText().toString();
                binding.repeatTv.setText(neverBtn.getText().toString());
                alertDialog.dismiss();

            }
        });
        RadioButton everyDay = alertDialog.findViewById(R.id.every_day);
        everyDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                repeatCount = everyDay.getText().toString();
                binding.repeatTv.setText(everyDay.getText().toString());
                alertDialog.dismiss();
            }
        });
        RadioButton everyWeek = alertDialog.findViewById(R.id.every_week);
        everyWeek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                repeatCount = everyWeek.getText().toString();
                binding.repeatTv.setText(everyWeek.getText().toString());
                alertDialog.dismiss();
            }
        });
        RadioButton everyMonth = alertDialog.findViewById(R.id.every_month);
        everyMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                repeatCount = everyMonth.getText().toString();
                binding.repeatTv.setText(everyMonth.getText().toString());
                alertDialog.dismiss();
            }
        });
        RadioButton everyYear = alertDialog.findViewById(R.id.every_year);
        everyYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                repeatCount = everyYear.getText().toString();
                binding.repeatTv.setText(everyYear.getText().toString());
                alertDialog.dismiss();
            }
        });
    }

    private void showDialog() {
        Calendar calendar = Calendar.getInstance();
        startYear = calendar.get(Calendar.YEAR);
        starthMonth = calendar.get(Calendar.MONTH);
        startDay = calendar.get(Calendar.DAY_OF_MONTH);
DatePickerDialog datePickerDialog = new DatePickerDialog(
        requireContext(),this::onDateSet,startYear,starthMonth,startDay);
datePickerDialog.show();
    }

    private void passModelToHomeFragment() {
        userTask = binding.taskEd.getText().toString();

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
binding.dateTv.setText(year+","+month+","+dayOfMonth);
    }
}