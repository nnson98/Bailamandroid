package com.example.doanmonhoc;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class GioSanAdapter extends BaseAdapter {
    private GioSan context;
    private int layout;
    private List<GioSanClass> gioSanClassList;

    public GioSanAdapter(GioSan context, int layout, List<GioSanClass> gioSanClassList) {
        this.context = context;
        this.layout = layout;
        this.gioSanClassList = gioSanClassList;
    }

    @Override
    public int getCount() {
        return gioSanClassList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    private  class  ViewHolder{
        TextView txtngaydat,txttensan,txtthoigianbatdau,txtthoigianketthuc,txttentt,txttennc,txttongtien,txtphone;
        ImageView imgXoa;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(layout,null);
            holder=new ViewHolder();
            holder.txttensan=(TextView) view.findViewById(R.id.txttensan);
            holder.txtngaydat=(TextView) view.findViewById(R.id.txtNgayDatSanBanh);
            holder.txtthoigianbatdau=(TextView) view.findViewById(R.id.txtthoigianbatdau);
            holder.txtthoigianketthuc=(TextView) view.findViewById(R.id.txtthoigianketthuc);
            holder.txttentt=(TextView) view.findViewById(R.id.txttentt);
            holder.txttennc=(TextView) view.findViewById(R.id.txttennuoc);
            holder.txttongtien=(TextView) view.findViewById(R.id.txttongtien);
            holder.txtphone=(TextView) view.findViewById(R.id.txtphone);
            holder.imgXoa=(ImageView) view.findViewById(R.id.imghinhdelete);
            view.setTag(holder);
        }else {
            holder= (ViewHolder) view.getTag();
        }
        final GioSanClass gioSanClass=gioSanClassList.get(i);
        holder.txttensan.setText(gioSanClass.getTensan());
        holder.txtngaydat.setText(gioSanClass.getNgaydat());
        holder.txtthoigianbatdau.setText(gioSanClass.getThoigianbatdau());
        holder.txtthoigianketthuc.setText(gioSanClass.getThoigianketthuc());
        holder.txttentt.setText(gioSanClass.getTentt());
        holder.txttennc.setText(gioSanClass.getTennuoc());
        holder.txttongtien.setText(gioSanClass.getTongtien());
        holder.txtphone.setText(gioSanClass.getPhone());
        holder.imgXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XacNhanXoa(gioSanClass.getTensan(),gioSanClass.getId());
            }
        });
        return view;
    }
    private  void XacNhanXoa(String ten, final int id){
        AlertDialog.Builder dialogXoa=new AlertDialog.Builder(context);
        dialogXoa.setMessage("Ban co muon xoa san "+ten+" khong ?");
        dialogXoa.setPositiveButton("Co", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                context.DeleteHoadon(id);
            }
        });
        dialogXoa.setNegativeButton("Khong", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dialogXoa.show();
    }
}
