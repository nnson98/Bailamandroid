package com.example.doanmonhoc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TrangChuApdapter extends BaseAdapter{
    private Context context;
    private int layout;
    private List<TrangChuClass> trangChuClassList;

    public TrangChuApdapter(Context context, int layout, List<TrangChuClass> trangChuClassList) {
        this.context = context;
        this.layout = layout;
        this.trangChuClassList = trangChuClassList;
    }

    @Override
    public int getCount() {
        return trangChuClassList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    public class ViewHolder{
        ImageView imgHinh;
        TextView txtTen;

    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view==null){
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(layout,null);
            holder=new ViewHolder();
            holder.txtTen=(TextView) view.findViewById(R.id.txtTenActivity);
            holder.imgHinh=(ImageView) view.findViewById(R.id.imgHinhActivity);
            view.setTag(holder);
        }
        else {
            holder=(ViewHolder) view.getTag();
        }
        TrangChuClass trangChuClass=trangChuClassList.get(i);
        holder.txtTen.setText(trangChuClass.getTen());
        holder.imgHinh.setImageResource(trangChuClass.getHinh());
        return view;
    }
    }

