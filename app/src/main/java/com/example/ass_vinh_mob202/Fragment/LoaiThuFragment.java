package com.example.ass_vinh_mob202.Fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ass_vinh_mob202.AdapterRecycleView.LoaiThuFragmentAdapter;
import com.example.ass_vinh_mob202.R;
import com.example.ass_vinh_mob202.database.ThuChiSqlite;
import com.example.ass_vinh_mob202.modal.ThuChi;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class LoaiThuFragment extends Fragment {
    private RecyclerView recyclerView;
    private ThuChiSqlite thuChiSqlite;
    private FloatingActionButton floatingActionButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.loai_thu_frag, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rv_loai_thu);
        floatingActionButton = view.findViewById(R.id.fab_loai_thu);
        thuChiSqlite = new ThuChiSqlite(getContext());

        LoaiThuFragmentAdapter loaiThuFragmentAdapter = new LoaiThuFragmentAdapter(getContext(), this, thuChiSqlite);
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
                        ThuChi thuChi = new ThuChi(ten, ThuChi.THU);
                        long result = thuChiSqlite.insertThuChi(thuChi);
                        if (result > 0) {
                            Toast.makeText(getContext(), "OK", Toast.LENGTH_SHORT).show();
                            updateItemRecycle(thuChiSqlite.getAllThu());
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
        LoaiThuFragmentAdapter loaiThuFragmentAdapter = new LoaiThuFragmentAdapter(getContext(), this, thuChiSqlite);
        recyclerView.setAdapter(loaiThuFragmentAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    public void editItemRecycleView(final ThuChi thuChi) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View view = LayoutInflater.from(getContext()).inflate(R.layout.dialog_edit_loai_thu, null, false);
        EditText editText = view.findViewById(R.id.ed_edit_loai_thu_dialog);
        editText.setText(thuChi.ten);
        builder.setView(view);
        builder.setNegativeButton("Cancel", null);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                int result = thuChiSqlite.updateThuChi(thuChi);
                Toast.makeText(getContext(), thuChi.id, Toast.LENGTH_SHORT).show();
            }
        });

        builder.show();

    }

    public void deleteItem(final ThuChi thuChi) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage("Bạn có chắc chắn muốn xóa ?");
        builder.setNegativeButton("Cancel", null);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Log.e("AAA", thuChi.id);
                long result = thuChiSqlite.delThuChi(thuChi.id);

                int siE = thuChiSqlite.getAllChi().size();
                int siii = thuChiSqlite.getAllThu().size();
                Log.e("AA", String.valueOf(siii));
                Log.e("AVB", String.valueOf(siE));
                Toast.makeText(getContext(), result + "", Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }

}
