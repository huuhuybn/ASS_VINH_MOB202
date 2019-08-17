package com.example.ass_vinh_mob202.Fragment;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ass_vinh_mob202.AdapterRecycleView.KhoanThuFragmentAdapter;
import com.example.ass_vinh_mob202.R;
import com.example.ass_vinh_mob202.SpinnerAdapter;
import com.example.ass_vinh_mob202.database.ThuChiSqlite;
import com.example.ass_vinh_mob202.modal.ThuChi;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class KhoanThuFragment extends Fragment {
    //    nap du lieu vao recycle view
    private RecyclerView recyclerView;
    private FloatingActionButton floatingActionButton;
    //    nap du lieu vao spinner
    private ThuChiSqlite thuChiSqlite;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.khoan_thu_frag, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rv_khoan_thu);
        thuChiSqlite = new ThuChiSqlite(getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        floatingActionButton = view.findViewById(R.id.fab_khoan_thu);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final View dialog = LayoutInflater.from(getContext()).inflate(R.layout.dialog_edit_khoan_thu, null, false);
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                final Spinner spinner = dialog.findViewById(R.id.spinner_khoan_thu);
                SpinnerAdapter spinnerAdapter = new SpinnerAdapter(thuChiSqlite.getAllThu(), getContext());
                spinner.setAdapter(spinnerAdapter);
                builder.setNegativeButton("HỦY", null);
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


