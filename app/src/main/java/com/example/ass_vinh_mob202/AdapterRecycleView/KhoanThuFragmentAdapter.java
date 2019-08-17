package com.example.ass_vinh_mob202.AdapterRecycleView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ass_vinh_mob202.R;
import com.example.ass_vinh_mob202.modal.ThuChi;

import java.util.List;


public class KhoanThuFragmentAdapter extends RecyclerView.Adapter<KhoanThuFragmentAdapter.KhoanThuHolder> {
    private List<ThuChi> thuChis;
    private Context context;

    public KhoanThuFragmentAdapter(Context context,List<ThuChi> thuChis) {
        this.thuChis = thuChis;
        this.context=context;
    }

    @NonNull
    @Override
    public KhoanThuHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.khoan_thu_recycle,parent,false);
        return new KhoanThuHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KhoanThuHolder holder, int position) {
        holder.tv_khoan_thu.setText(thuChis.get(position).loaiThuChi);

    }

    @Override
    public int getItemCount() {
        return thuChis.size();
    }

    public class KhoanThuHolder extends RecyclerView.ViewHolder {
        public TextView tv_khoan_thu;
        public ImageView ed_khoan_thu,delete_khoan_thu;
        public KhoanThuHolder(@NonNull View itemView) {
            super(itemView);
            tv_khoan_thu=itemView.findViewById(R.id.tv_khoan_thu);
            ed_khoan_thu=itemView.findViewById(R.id.edit_khoan_thu);
            delete_khoan_thu=itemView.findViewById(R.id.delete_khoan_thu);
        }
    }
}
