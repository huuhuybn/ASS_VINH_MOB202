package com.example.ass_vinh_mob202;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ass_vinh_mob202.modal.ThuChi;

import java.util.List;

public class SpinnerAdapter implements android.widget.SpinnerAdapter {
    private List<ThuChi> thuChis;
    private Context context;

    public SpinnerAdapter(List<ThuChi> thuChis, Context context) {
        this.thuChis = thuChis;
        this.context = context;
    }

    @Override
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        view= LayoutInflater.from(context).inflate(R.layout.spinner_khoan_thu,null,false);
        TextView textView=view.findViewById(R.id.tv_spinner);
        textView.setText(thuChis.get(i).ten);
        return view;
    }

    @Override
    public int getCount() {
        return thuChis.size();
    }

    @Override
    public Object getItem(int i) {
        return thuChis.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view= LayoutInflater.from(context).inflate(R.layout.spinner_khoan_thu,null,false);
        TextView textView=view.findViewById(R.id.tv_spinner);
        textView.setText(thuChis.get(i).ten);
        return view;
    }

    @Override
    public int getItemViewType(int i) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

    }
    @Override
    public boolean hasStableIds() {
        return false;
    }
}
