package com.example.doanmonhoc;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class SanBongApdapter extends BaseAdapter {
    private DanhSachSanBong context;
    private int layout;
    private List<SanBong> sanBongList;

    public SanBongApdapter(DanhSachSanBong context, int layout, List<SanBong> sanBongList) {
        this.context = context;
        this.layout = layout;
        this.sanBongList = sanBongList;
    }

    @Override
    public int getCount() {
        return sanBongList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    private class ViewHolder2{
        ImageView imgHinhSanBanh;
        TextView txtTenSan,txtLoaiSan,txtDonGia;
        Button btnDatsan;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder2 holder2;
        if(view==null){
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(layout,null);
            holder2=new ViewHolder2();
            holder2.txtTenSan=(TextView) view.findViewById(R.id.txtTenSanBanh);
            holder2.txtDonGia=(TextView) view.findViewById(R.id.txtDonGiaSan);
            holder2.txtLoaiSan=(TextView) view.findViewById(R.id.txtLoaiSan);
            holder2.imgHinhSanBanh=(ImageView) view.findViewById(R.id.imgHinhSanBanh);
            holder2.btnDatsan=(Button) view.findViewById(R.id.btndatsan);
            view.setTag(holder2);
        }else {
            holder2= (ViewHolder2) view.getTag();
        }
        final SanBong sanBong=sanBongList.get(i);
        holder2.txtTenSan.setText(sanBong.getTenSan());
        holder2.txtLoaiSan.setText(sanBong.getLoaiSan());
        holder2.txtDonGia.setText(sanBong.getDonGiaSanBanh()+"");
        Picasso.with(context).load(sanBong.getHinhSanBanh()).into(holder2.imgHinhSanBanh);
        holder2.btnDatsan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,HoaDonActivity.class);
                intent.putExtra("datasan",sanBong);
                context.startActivity(intent);
            }
        });
        return view;
    }
}
