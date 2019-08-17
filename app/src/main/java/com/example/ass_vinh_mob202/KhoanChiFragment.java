package com.example.ass_vinh_mob202;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ass_vinh_mob202.AdapterRecycleView.KhoanThuFragmentAdapter;
import com.example.ass_vinh_mob202.database.ThuChiSqlite;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class KhoanChiFragment extends Fragment {
    private RecyclerView recyclerView;
    private ThuChiSqlite thuChiSqlite;
    private FloatingActionButton floatingActionButton;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.khoan_chi_frag,container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rv_khoan_thu);
        thuChiSqlite=new ThuChiSqlite(getContext());
        floatingActionButton=view.findViewById(R.id.fab_khoan_chi);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View dialog=LayoutInflater.from(getContext()).inflate(R.layout.dialog_edit_khoan_thu,null,false);
                AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
                final Spinner spinner=dialog.findViewById(R.id.spinner_khoan_thu);
                SpinnerAdapter spinnerAdapter=new SpinnerAdapter(thuChiSqlite.getAllChi(),getContext());
                spinner.setAdapter(spinnerAdapter);
                builder.setNegativeButton("HỦY",null);
                builder.setPositiveButton("THÊM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {


                    }
                });
                builder.setView(dialog);
                builder.show();

            }
        });
    }
}
