package com.example.doanmonhoc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HoaDonActivity extends AppCompatActivity {
    EditText editTextTentt,editTextTienThueTT,editTextTenNuoc,editTextTinhTienNuoc,editTextSoLuongNuoc,editTextPhone;
    Button btnDongY,btnXacNhan,btnHuy;
    Spinner spinnerTenTT, spinnerNuocuong;
    TextView txtngaydat, txtgiobatdau, txtgioketthuc,txtTenSan;
    Calendar calendar1, calendar2;
    List<TenTT> tenTTList;
    TenTTAdapter adapter1;
    List<TenNuoc> tenNuocList;
    TenNuocAdapter adapter2;
    String urlgetdatatentt = "http://192.168.0.99:8080/DoanMonHoc/getdataTentt.php";
    String urlgetdatatennuoc = "http://192.168.0.99:8080/DoanMonHoc/getdatattenuoc.php";
    String urlkiemtragio="http://192.168.0.99:8080/DoanMonHoc/kiemtragio.php";
    String urlgetdataHoaDon="http://192.168.0.99:8080/DoanMonHoc/themhoadon.php";
    EditText editTextTinhTienSan,editTextTongTien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoa_don);

        anhxa();

        editTextPhone.setText("0944705204");
        editTextSoLuongNuoc.setText("0");

        Intent intent = getIntent();
        SanBong sanBong = (SanBong) intent.getSerializableExtra("datasan");
        txtTenSan.setText(sanBong.getTenSan());




        adapter1 = new TenTTAdapter(this, R.layout.dong_spinnertentt, tenTTList);
        spinnerTenTT.setAdapter(adapter1);
        getdatatententt(urlgetdatatentt);
        adapter2 = new TenNuocAdapter(this, R.layout.dong_spinnertennuoc, tenNuocList);
        spinnerNuocuong.setAdapter(adapter2);
        getdatatentennuoc(urlgetdatatennuoc);
        txtngaydat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        txtgiobatdau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Chongio1();
            }
        });
        txtgioketthuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Chongio2();
            }
        });
        btnDongY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a=txtngaydat.getText().toString().trim();
                String b=txtgiobatdau.getText().toString().trim();
                String c=txtgioketthuc.getText().toString().trim();
                if(a.isEmpty()||b.isEmpty()||c.isEmpty()){
                    Toast.makeText(HoaDonActivity.this, "Chưa có đủ dữ liệu ngày giờ", Toast.LENGTH_SHORT).show();
                }else {
                    tinhTienSan();
                    tentt();
                    tennuoc();
                    KiemtraThoiGian(urlkiemtragio);
                    TinTienSan();
                }

            }
        });
        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog();
            }
        });

    }

    private void anhxa() {
        editTextTongTien=(EditText) findViewById(R.id.edtTongTien);
        btnXacNhan=(Button) findViewById(R.id.btnxacnhan) ;
        editTextPhone=(EditText) findViewById(R.id.edtPhone);
        editTextSoLuongNuoc=(EditText) findViewById(R.id.edtSoLuongNuoc) ;
        editTextTinhTienNuoc=(EditText) findViewById(R.id.edtTinhTienNuoc);
        editTextTenNuoc=(EditText) findViewById(R.id.editTenNuoc);
        editTextTienThueTT=(EditText) findViewById(R.id.edtTienThueTT);
        editTextTentt=(EditText) findViewById(R.id.edtTenTrongTai);
        txtTenSan= (TextView) findViewById(R.id.edtTenSan);
        btnDongY = (Button) findViewById(R.id.btnTinhTien);
        editTextTinhTienSan = (EditText) findViewById(R.id.edtTinhtiensan);
        txtngaydat = (TextView) findViewById(R.id.txtNgayDatSan);
        txtgiobatdau = (TextView) findViewById(R.id.txtThoiGianBatdau);
        txtgioketthuc = (TextView) findViewById(R.id.txtThoiGianKetThuc);
        spinnerTenTT = (Spinner) findViewById(R.id.spinnerTenTT);
        tenTTList = new ArrayList<>();
        tenTTList.add(new TenTT("Chọn trọng tài"));
        spinnerNuocuong = (Spinner) findViewById(R.id.spinnerTenNuoc);
        tenNuocList = new ArrayList<>();
        tenNuocList.add(new TenNuoc("Chọn nước"));
    }


    private void getdatatententt(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject object = response.getJSONObject(i);
                        tenTTList.add(new TenTT(object.getString("HoTenTT")));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter1.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonArrayRequest);
    }

    private void getdatatentennuoc(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject object = response.getJSONObject(i);
                        tenNuocList.add(new TenNuoc(object.getString("TenNuoc")));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter2.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonArrayRequest);
    }



    private void Chongio1() {
        calendar1 = Calendar.getInstance();
        int gio = calendar1.get(Calendar.HOUR);
        int phut = calendar1.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
                calendar1.set(0, 0, 0, i, i1);
                txtgiobatdau.setText(simpleDateFormat.format(calendar1.getTime()));
            }
        }, gio, phut, true);
        timePickerDialog.show();
    }

    private void Chongio2() {
        calendar2 = Calendar.getInstance();
        int gio = calendar2.get(Calendar.HOUR);
        int phut = calendar2.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
                calendar2.set(0, 0, 0, i, i1);
                txtgioketthuc.setText(simpleDateFormat.format(calendar2.getTime()));
            }
        }, gio, phut, true);
        timePickerDialog.show();
    }

    private void tinhTienSan() {
        int tongtin = 0;
        int tongtin2=0;
        int giobatdau = (int) (calendar1.getTimeInMillis() / (1000 * 60 ));
        int gioketthuc = (int) (calendar2.getTimeInMillis()/ (1000 * 60 ));
        int tinhgio = (gioketthuc - giobatdau);
        tongtin = tinhgio * 100000/60;
        tongtin2=tinhgio*200000/60;
         if(tongtin<0){
            Toast.makeText(this, "Phải nhập giờ kết thúc sau giờ bắt đầu", Toast.LENGTH_SHORT).show();
        }else if(txtTenSan.getText().equals("Sân 1")||txtTenSan.getText().equals("Sân 2")||txtTenSan.getText().equals("Sân 3")){
            editTextTinhTienSan.setText(tongtin+"");
        }else if(txtTenSan.getText().equals("Sân 4")||txtTenSan.getText().equals("Sân5")) {
             editTextTinhTienSan.setText(tongtin2+"");
        }


    }
    private void tentt(){
        int tongtin2 = 0;
        int giobatdau2 = (int) (calendar1.getTimeInMillis() / (1000 * 60 ));
        int gioketthuc2 = (int) (calendar2.getTimeInMillis()/ (1000 * 60 ));
        int tinhgio2 = (gioketthuc2 - giobatdau2);

        String i = String.valueOf(spinnerTenTT.getSelectedItemPosition());
        if(i.equals("0")){
            editTextTentt.setText("");
            editTextTienThueTT.setText("");
        }else if(i.equals("1")){
            editTextTentt.setText("Nguyễn Văn A");
            tongtin2=tinhgio2*100000/60;
            editTextTienThueTT.setText(tongtin2+"");
        }else if(i.equals("2")){
            editTextTentt.setText("Nguyễn Văn B");
            tongtin2=tinhgio2*100000/60;
            editTextTienThueTT.setText(tongtin2+"");
        }else if(i.equals("3")){
            editTextTentt.setText("Trần Văn C");
            tongtin2=tinhgio2*150000/60;
            editTextTienThueTT.setText(tongtin2+"");
        }
    }
    private void tennuoc(){
        String y = String.valueOf(spinnerNuocuong.getSelectedItemPosition());
        String a=editTextSoLuongNuoc.getText().toString().trim();
        int b=Integer.parseInt(a);
        int c=10000;
        int d=12000;

         if(y.equals("0")){
            editTextTenNuoc.setText("");

            editTextTinhTienNuoc.setText(""+(b*c));
        }else if(y.equals("1")){
            editTextTenNuoc.setText("Pepsi");
            editTextTinhTienNuoc.setText(""+(b*c));

        }else if(y.equals("2")){
            editTextTenNuoc.setText("Sting");
            editTextTinhTienNuoc.setText(""+(b*c));

        }else if(y.equals("3")){
             editTextTenNuoc.setText("7Up");
             editTextTinhTienNuoc.setText(""+(b*c));
         }else if(y.equals("4")){
             editTextTenNuoc.setText("Revive");
             editTextTinhTienNuoc.setText(""+(b*d));
         }else if(y.equals("5")){
             editTextTenNuoc.setText("Nước Revive chanh muối ");
             editTextTinhTienNuoc.setText(""+(b*d));
         }
    }
    private void ThemHoaDon(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.trim().equals("success")) {
                    Toast.makeText(HoaDonActivity.this, "Them thanh cong", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(HoaDonActivity.this, GioSan.class));
                    finish();
                } else {
                    Toast.makeText(HoaDonActivity.this, "Them that bai", Toast.LENGTH_SHORT).show();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(HoaDonActivity.this, "Looi qua trinh", Toast.LENGTH_SHORT).show();

                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("ngaydatSan",txtngaydat.getText().toString().trim());
                params.put("tenSan",txtTenSan.getText().toString().trim());
                params.put("thoigianbatdauSan",txtgiobatdau.getText().toString().trim());
                params.put("thoigianketthucSan",txtgioketthuc.getText().toString().trim());
                params.put("tenttSan",editTextTentt.getText().toString().trim());
                params.put("tennuocSan",editTextTenNuoc.getText().toString().trim());
                params.put("thanhtienSan",editTextTongTien.getText().toString().trim());
                params.put("phoneSan",editTextPhone.getText().toString().trim());
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void KiemtraThoiGian(String url){
        RequestQueue requestQueue=Volley.newRequestQueue(this);
        StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.trim().equals("success")){
                    Toast.makeText(HoaDonActivity.this, "Giờ này còn trống", Toast.LENGTH_SHORT).show();

                }
                else{
                    Toast.makeText(HoaDonActivity.this, "Gio da bi trung", Toast.LENGTH_SHORT).show();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(HoaDonActivity.this, "Loi qua trinh", Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<>();
                params.put("ngaySan",txtngaydat.getText().toString().trim());
                params.put("thoigianbatdauSan",txtgiobatdau.getText().toString().trim());
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
    private void Dialog(){
        Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.dong_themhoadon);
        Button btnDongy=(Button) dialog.findViewById(R.id.btnThemHoaDon);
        Button btnHuy=(Button) dialog.findViewById(R.id.btnHuyHoaDon);
        btnDongy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ThemHoaDon(urlgetdataHoaDon);
            }
        });
        dialog.show();
    }
    private void TinTienSan(){

        String a=editTextTinhTienSan.getText().toString().trim();
        String b=editTextTienThueTT.getText().toString().trim();
        String c=editTextTinhTienNuoc.getText().toString().trim();

        int d=Integer.parseInt(a);
        int e=Integer.parseInt(b);
        int f=Integer.parseInt(c);
        if(a.length()==0 && b.length()==0 && c.length()==0){
            editTextTongTien.setText("0");
        }else if (b.length()==0 && c.length()==0){
            editTextTongTien.setText(""+(d));
        }else if(c.length()==0){
            editTextTongTien.setText(""+(d+e));
        }else if(b.length()==0){
        editTextTongTien.setText(""+(d+f));
        }else {
            editTextTongTien.setText(""+(d+f+e));
        }
    }
}

