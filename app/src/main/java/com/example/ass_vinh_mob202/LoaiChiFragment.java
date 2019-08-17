package com.example.ass_vinh_mob202;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ass_vinh_mob202.AdapterRecycleView.LoaiThuFragmentAdapter;
import com.example.ass_vinh_mob202.database.ThuChiSqlite;
import com.example.ass_vinh_mob202.modal.ThuChi;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class LoaiChiFragment extends Fragment {
    private RecyclerView recyclerView;
    private FloatingActionButton floatingActionButton;
    private ThuChiSqlite thuChiSqlite;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.loai_chi_frag,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rv_loai_chi);
        floatingActionButton = view.findViewById(R.id.fav_loai_chi);
        thuChiSqlite = new ThuChiSqlite(getContext());

        LoaiChiFragmentAdapter loaiThuFragmentAdapter = new LoaiChiFragmentAdapter(getContext(), this, thuChiSqlite);
        recyclerView.setAdapter(loaiThuFragmentAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                View V = LayoutInflater.from(getContext()).inflate(R.layout.dialog_add_loai_thu, null, false);
                builder.setView(V);
                builder.setNegativeButton("HỦY", null);
                final EditText editText = V.findViewById(R.id.custom_dialog_loai_thu_ed);
                builder.setPositiveButton("THÊM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String ten = editText.getText().toString();
                        ThuChi thuChi = new ThuChi(ten,ThuChi.CHI);
                        long result = thuChiSqlite.insertThuChi(thuChi);
                        if (result > 0) {
                            Toast.makeText(getContext(), "OK", Toast.LENGTH_SHORT).show();
                            updateItemRecycle(thuChiSqlite.getAllChi());
                        } else {
                            Toast.makeText(getContext(), "null", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                builder.show();
            }
        });
    }
    public void updateItemRecycle(List<ThuChi> tenThu) {
        LoaiChiFragmentAdapter loaiChiFragment = new LoaiChiFragmentAdapter(getContext(), this, thuChiSqlite);
        recyclerView.setAdapter(loaiChiFragment);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}
