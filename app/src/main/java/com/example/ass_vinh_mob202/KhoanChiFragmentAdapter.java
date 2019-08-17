package com.example.ass_vinh_mob202;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ass_vinh_mob202.modal.ThuChi;

import java.util.List;

public class KhoanChiFragmentAdapter extends RecyclerView.Adapter<KhoanChiFragmentAdapter.KhoanChiHolder> {
    private List<ThuChi> thuChis;
    private Context context;

    public KhoanChiFragmentAdapter(List<ThuChi> thuChis, Context context) {
        this.thuChis = thuChis;
        this.context = context;
    }

    @NonNull
    @Override
    public KhoanChiFragmentAdapter.KhoanChiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new KhoanChiHolder(LayoutInflater.from(context).inflate(R.layout.khoan_chi_recycle,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull KhoanChiFragmentAdapter.KhoanChiHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class KhoanChiHolder extends RecyclerView.ViewHolder {
        public KhoanChiHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
