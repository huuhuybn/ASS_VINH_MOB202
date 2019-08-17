package com.example.ass_vinh_mob202;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class ChiFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.chi_frag,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tabLayout=view.findViewById(R.id.tab_chi);
        viewPager=view.findViewById(R.id.view_chi);
        FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
        MyAdapter2 myAdapter=new MyAdapter2(fragmentManager);
        viewPager.setAdapter(myAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
