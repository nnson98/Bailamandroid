package com.example.doanmonhoc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class TrangChu extends AppCompatActivity {
    GridView gvTrangChu;
    List<TrangChuClass> arrayTrangChu;
    TrangChuApdapter adapter;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);
        Anhxa();
        adapter=new TrangChuApdapter(this,R.layout.dong_trangchu,   arrayTrangChu);
        gvTrangChu.setAdapter(adapter);
        gvTrangChu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    startActivity(new Intent(TrangChu.this,ThongTinCaNhanActivity.class));

                }else if(i==1){
                    startActivity(new Intent(TrangChu.this,DanhSachTrongTai.class));

                }else if(i==2){
                    startActivity(new Intent(TrangChu.this,DanhSachNuocUong.class));

                }else if(i==3){
                    startActivity(new Intent(TrangChu.this,DanhSachSanBong.class));

                }else  if(i==4){
                    startActivity(new Intent(TrangChu.this,GioSan.class));
                }
            }
        });

    }

    private void Anhxa() {
        gvTrangChu=(GridView) findViewById(R.id.gripviewCV);
        arrayTrangChu=new ArrayList<>();
        arrayTrangChu.add(new TrangChuClass("Thông tin cá nhân",R.drawable.icon_thongtin));
        arrayTrangChu.add(new TrangChuClass("Danh sách trọng tài",R.drawable.icon_trongtai));
        arrayTrangChu.add(new TrangChuClass("Danh sách nước uống",R.drawable.icon_nuoc));
        arrayTrangChu.add(new TrangChuClass("Danh sách sân bãi",R.drawable.hello));
        arrayTrangChu.add(new TrangChuClass("Giỏ sân",R.drawable.datsan));
    }
}
