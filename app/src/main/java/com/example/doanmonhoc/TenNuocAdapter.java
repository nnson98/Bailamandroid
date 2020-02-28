package com.example.doanmonhoc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class TenNuocAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<TenNuoc> tenNuocs;

    public TenNuocAdapter(Context context, int layout, List<TenNuoc> tenNuocs) {
        this.context = context;
        this.layout = layout;
        this.tenNuocs = tenNuocs;
    }

    @Override
    public int getCount() {
        return tenNuocs.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view=inflater.inflate(layout,null);
        TextView txtTenNuoc=(TextView) view.findViewById(R.id.textViewspinnernuoc);

        TenNuoc tenNuoc=tenNuocs.get(i);
        txtTenNuoc.setText(tenNuoc.getTennuoc());
        return view;
    }
}
