package com.example.ass_vinh_mob202.AdapterRecycleView;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ass_vinh_mob202.Fragment.LoaiThuFragment;
import com.example.ass_vinh_mob202.R;
import com.example.ass_vinh_mob202.database.ThuChiSqlite;
import com.example.ass_vinh_mob202.modal.ThuChi;

import java.util.List;

public class LoaiThuFragmentAdapter extends RecyclerView.Adapter<LoaiThuFragmentAdapter.LoaiThuHolder> {
    private Context context;
    private LoaiThuFragment loaiThuFragment;
    private ThuChiSqlite thuChiSqlite;


    public LoaiThuFragmentAdapter(Context context, LoaiThuFragment loaiThuFragment, ThuChiSqlite thuChiSqlite) {
        this.context = context;
        this.loaiThuFragment = loaiThuFragment;
        this.thuChiSqlite = thuChiSqlite;
    }

    @NonNull
    @Override
    public LoaiThuFragmentAdapter.LoaiThuHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new LoaiThuHolder(LayoutInflater.from(context).inflate(R.layout.loai_thu_recycle, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LoaiThuFragmentAdapter.LoaiThuHolder holder, final int position) {
        holder.del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loaiThuFragment.deleteItem(thuChiSqlite.getAllThu().get(position));
            }
        });
        holder.ed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loaiThuFragment.editItemRecycleView(thuChiSqlite.getAllThu().get(position));
            }
        });
        holder.textView.setText(thuChiSqlite.getAllThu().get(position).ten);

    }

    @Override
    public int getItemCount() {
        return thuChiSqlite.getAllThu().size();
    }

    public class LoaiThuHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public ImageView ed;
        public ImageView del;

        public LoaiThuHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_loai_thu);
            ed = itemView.findViewById(R.id.ed_loai_thu);
            del = itemView.findViewById(R.id.del_loai_thu);

        }
    }
}
