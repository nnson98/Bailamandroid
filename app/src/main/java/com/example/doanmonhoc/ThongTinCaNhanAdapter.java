package com.example.doanmonhoc;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class ThongTinCaNhanAdapter extends BaseAdapter {
    private ThongTinCaNhanActivity context;
    private int layout;
    private List<ThongTinCaNhan> thongTinCaNhanList;

    public ThongTinCaNhanAdapter(ThongTinCaNhanActivity context, int layout, List<ThongTinCaNhan> thongTinCaNhanList) {
        this.context = context;
        this.layout = layout;
        this.thongTinCaNhanList = thongTinCaNhanList;
    }

    @Override
    public int getCount() {
        return thongTinCaNhanList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    private class ViewHolder{
        TextView txtname,txtphone;
        Button btnCapNhap;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view==null){
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(layout,null);
            holder=new ViewHolder();
            holder.txtname=(TextView) view.findViewById(R.id.txtTenUser);
            holder.txtphone=(TextView) view.findViewById(R.id.txtPhone);
            holder.btnCapNhap=(Button) view.findViewById(R.id.btnCapNhat);
            view.setTag(holder);
        }else {
            holder= (ViewHolder) view.getTag();
        }
        ThongTinCaNhan thongTinCaNhan= thongTinCaNhanList.get(i);
        holder.txtname.setText(thongTinCaNhan.getName());
        holder.txtphone.setText(thongTinCaNhan.getPhone());


        return view;
    }
}
