package com.example.doanmonhoc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GioSan extends AppCompatActivity {
    ListView lvGioSan;
    List<GioSanClass> gioSanClassList;
    GioSanAdapter adapter;
    String urlgetdatatGiosan="http://192.168.0.99:8080/DoanMonHoc/getdatagiosan.php";
    String urlDelete="http://192.168.0.99:8080/DoanMonHoc/deletehoadon.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gio_san);
        anhxa();
        adapter=new GioSanAdapter(this,R.layout.dong_giosan,gioSanClassList);
        lvGioSan.setAdapter(adapter);
        GetData(urlgetdatatGiosan);
    }
    private void GetData(String url){
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                gioSanClassList.clear();
                for (int i =0 ; i<response.length();i++){

                    try {
                        JSONObject object= response.getJSONObject(i);
                        gioSanClassList.add(new GioSanClass(object.getInt("Id"),
                                object.getString("NgayDat"),
                                object.getString("TenSan"),
                                object.getString("ThoiGianBatDau"),
                                object.getString("ThoiGianKetThuc"),
                                object.getString("TenTT"),
                                object.getString("TenNC"),
                                object.getString("ThanhTien"),
                                object.getString("Phone")));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter.notifyDataSetChanged();
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(GioSan.this, "Loi", Toast.LENGTH_SHORT).show();
                    }
                });
        requestQueue.add(jsonArrayRequest);
    }

    private void anhxa() {
        lvGioSan=(ListView) findViewById(R.id.lvGioSan);
        gioSanClassList=new ArrayList<>();
    }
    public void DeleteHoadon(final int idsv){
        RequestQueue requestQueue=Volley.newRequestQueue(this);
        StringRequest stringRequest=new StringRequest(Request.Method.POST, urlDelete, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.trim().equals("success")){
                    Toast.makeText(GioSan.this, "Xoa thanh cong", Toast.LENGTH_SHORT).show();
                    GetData(urlgetdatatGiosan);
                }else {
                    Toast.makeText(GioSan.this, "Xoa khogn thanh cong", Toast.LENGTH_SHORT).show();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(GioSan.this, "Loi qua trinh", Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<>();
                params.put("idKH",String.valueOf(idsv));
                return params;

            }

        };
        requestQueue.add(stringRequest);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_them,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent=new Intent(GioSan.this,TrangChu.class);
        startActivity(intent);
        finish();
        return super.onOptionsItemSelected(item);
    }
}
