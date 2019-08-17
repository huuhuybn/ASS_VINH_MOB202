package com.example.ass_vinh_mob202;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.ass_vinh_mob202.Fragment.KhoanThuFragment;
import com.example.ass_vinh_mob202.Fragment.LoaiThuFragment;

public class MyAdapter extends FragmentStatePagerAdapter {
    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                KhoanThuFragment khoanThuFragment = new KhoanThuFragment();
                return khoanThuFragment;
            case 1:
                LoaiThuFragment loaiThuFragment=new LoaiThuFragment();
                return loaiThuFragment;
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
            return "KHOẢN THU";
        }else if(position==1){
            return "LOẠI THU";
        }else{
            return null;
        }
    }
}
