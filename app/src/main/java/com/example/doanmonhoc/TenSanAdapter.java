package com.example.doanmonhoc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class TenSanAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<TenSan> tenSanList;

    public TenSanAdapter(Context context, int layout, List<TenSan> tenSanList) {
        this.context = context;
        this.layout = layout;
        this.tenSanList = tenSanList;
    }

    @Override
    public int getCount() {
        return tenSanList.size();
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
        TextView txtTenSan=(TextView) view.findViewById(R.id.textViewSpinner);

        TenSan tenSan=tenSanList.get(i);
        txtTenSan.setText(tenSan.getTenSanBong());
        return view;
    }
}
