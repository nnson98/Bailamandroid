package com.example.doanmonhoc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class TenTTAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<TenTT> tenTTList;

    public TenTTAdapter(Context context, int layout, List<TenTT> tenTTList) {
        this.context = context;
        this.layout = layout;
        this.tenTTList = tenTTList;
    }

    @Override
    public int getCount() {
        return tenTTList.size();
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

        TextView txtTenTT=(TextView) view.findViewById(R.id.textViewspinnerTenTT);

        TenTT tenTT=tenTTList.get(i);
        txtTenTT.setText(tenTT.getTenTT());
        return view;
    }
}
