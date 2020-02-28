package com.example.doanmonhoc;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class NuocApdapter extends BaseAdapter {
    private DanhSachNuocUong context;
    private int layout;
    private List<Nuoc> nuocList;

    public NuocApdapter(DanhSachNuocUong context, int layout, List<Nuoc> nuocList) {
        this.context = context;
        this.layout = layout;
        this.nuocList = nuocList;
    }

    @Override
    public int getCount() {
        return nuocList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    private class ViewHolder1{
        ImageView imageViewHinhNuoc;
        TextView txtTenNuoc,ttxDongiaNuoc;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder1 holder1;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder1 = new ViewHolder1();
            holder1.txtTenNuoc = (TextView) view.findViewById(R.id.txtTenNuocUong);
            holder1.ttxDongiaNuoc = (TextView) view.findViewById(R.id.txtDonGiaNuoc);
            holder1.imageViewHinhNuoc = (ImageView) view.findViewById(R.id.imgHinhNuocUong);
            view.setTag(holder1);

        }else {
            holder1= (ViewHolder1) view.getTag();
        }
        Nuoc nuoc= nuocList.get(i);
        holder1.txtTenNuoc.setText(nuoc.getTenNuoc());
        holder1.ttxDongiaNuoc.setText("Đơn giá 1 lon:"+" "+nuoc.getDonGia()+" "+"VND");
        Picasso.with(context).load(nuoc.getHinhNuoc()).into(holder1.imageViewHinhNuoc);
        return view;
    }
}
