package com.example.hi.board;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.hi.fragment.FirstFragment;
import com.example.hi.fragment.SecondFragment;
import com.example.hi.utils.Constants;



public class BoardAdapterFragment extends FragmentPagerAdapter {


    public BoardAdapterFragment(@NonNull FragmentManager fm) {
        super(fm);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        BoardFragment fragment = new BoardFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(Constants.FRAGMENT_POSITION,position);
        fragment.setArguments(bundle);
        return fragment;
    }
    public Fragment createFragment(int position){
        switch (position){
            case 1:
                return new BoardFragment();
            case 2:
                return new SecondFragment();
        }
        return new FirstFragment();
    }

    @Override
    public int getCount() {
        return 3;
    }
}