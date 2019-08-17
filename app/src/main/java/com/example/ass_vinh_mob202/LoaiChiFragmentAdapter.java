package com.example.ass_vinh_mob202;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ass_vinh_mob202.Fragment.LoaiThuFragment;
import com.example.ass_vinh_mob202.database.ThuChiSqlite;
import com.example.ass_vinh_mob202.modal.ThuChi;

import java.util.List;

public class LoaiChiFragmentAdapter extends RecyclerView.Adapter<LoaiChiFragmentAdapter.LoaiChiHolder> {
    private Context context;
    private LoaiChiFragment loaiChiFragment;
    private ThuChiSqlite thuChiSqlite;

    public LoaiChiFragmentAdapter(Context context, LoaiChiFragment loaiChiFragment, ThuChiSqlite thuChiSqlite) {
        this.context = context;
        this.loaiChiFragment = loaiChiFragment;
        this.thuChiSqlite = thuChiSqlite;
    }

    @NonNull
    @Override
    public LoaiChiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LoaiChiHolder(LayoutInflater.from(context).inflate(R.layout.loai_chi_recycle,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull LoaiChiHolder holder, int position) {
        holder.textView.setText(thuChiSqlite.getAllChi().get(position).ten);

    }

    @Override
    public int getItemCount() {
        return thuChiSqlite.getAllChi().size();
    }

    public class LoaiChiHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public ImageView imgdel,imgEdit;
        public LoaiChiHolder(@NonNull View itemView) {
            super(itemView);
            imgdel=itemView.findViewById(R.id.del_loai_chi);
            imgEdit=itemView.findViewById(R.id.del_loai_chi);
            textView=itemView.findViewById(R.id.tv_loai_chi);
        }
    }
}
