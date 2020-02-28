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

public class TrongTaiApdapter extends BaseAdapter {
    private DanhSachTrongTai context;
    private int layout;
    private List<TrongTai> trongTaiList;

    public TrongTaiApdapter(DanhSachTrongTai context, int layout, List<TrongTai> trongTaiList) {
        this.context = context;
        this.layout = layout;
        this.trongTaiList = trongTaiList;
    }

    @Override
    public int getCount() {
        return trongTaiList.size();
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
        ImageView imgHinhTT;
        TextView txtTenTT,txtTuoiTT,txtKnTT,txtSoTien;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view==null){
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(layout,null);
            holder=new ViewHolder();
            holder.imgHinhTT=(ImageView) view.findViewById(R.id.imgHinhTT);
            holder.txtTenTT=(TextView) view.findViewById(R.id.txtTenTT);
            holder.txtTuoiTT=(TextView) view.findViewById(R.id.txtNamSinhTT);
            holder.txtKnTT=(TextView) view.findViewById(R.id.txtKinhNgiemTT);
            holder.txtSoTien=(TextView) view.findViewById(R.id.txtTiuenThue);
            view.setTag(holder);
        }else {
            holder= (ViewHolder) view.getTag();
        }
        TrongTai trongTai=trongTaiList.get(i);
        holder.txtTenTT.setText(trongTai.getHotentt());
        holder.txtTuoiTT.setText("Số tuổi:"+" "+trongTai.getTuoitt());
        holder.txtKnTT.setText("Kinh ngiệm cầm còi:"+" "+trongTai.getKntt());
        holder.txtSoTien.setText("Đơn giá 1 giờ:"+" "+trongTai.getDongia()+" "+"VND");
        Picasso.with(context).load(trongTai.getHinhtt()).into(holder.imgHinhTT);
        return view;
    }
}
