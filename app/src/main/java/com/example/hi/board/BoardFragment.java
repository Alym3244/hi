package com.example.hi.board;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.hi.databinding.FragmentBoardBinding;
import com.example.hi.utils.Constants;


public class BoardFragment extends Fragment {

FragmentBoardBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
binding= FragmentBoardBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getPositionFromFragment();
    }

    public void getPositionFromFragment() {

        if (getArguments()!=null){
            int position = getArguments().getInt(Constants.FRAGMENT_POSITION);
            switch (position){

                case 0:
                    binding.description.setText("1");
                    break;
                case 1:
                    binding.description.setText("2");
                break;
                case 2:
                    binding.description.setText("3");

                    break;
            }
        }

    }
}