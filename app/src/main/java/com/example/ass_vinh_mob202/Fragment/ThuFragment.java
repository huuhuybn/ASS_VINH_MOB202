package com.example.ass_vinh_mob202.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.ass_vinh_mob202.AdapterRecycleView.LoaiThuFragmentAdapter;
import com.example.ass_vinh_mob202.MyAdapter;
import com.example.ass_vinh_mob202.R;
import com.example.ass_vinh_mob202.modal.ThuChi;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class ThuFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.thu_frag,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tabLayout=view.findViewById(R.id.tab);
        viewPager=view.findViewById(R.id.view);
        FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
        MyAdapter myAdapter=new MyAdapter(fragmentManager);
        viewPager.setAdapter(myAdapter);
        tabLayout.setupWithViewPager(viewPager);


    }
}

