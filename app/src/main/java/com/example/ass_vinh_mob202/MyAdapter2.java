package com.example.ass_vinh_mob202;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class MyAdapter2 extends FragmentStatePagerAdapter {
    public MyAdapter2(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position==0){
            KhoanChiFragment khoanChiFragment=new KhoanChiFragment();
            return khoanChiFragment;
        }else if(position==1){
            LoaiChiFragment loaiChiFragment=new LoaiChiFragment();
            return loaiChiFragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0){
            return "KHOẢN CHI";
        }else if(position==1){
            return "LOẠI CHI";
        }
        return null;
    }
}
