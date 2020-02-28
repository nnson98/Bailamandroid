package com.example.doanmonhoc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DanhSachSanBong extends AppCompatActivity {
    ListView lvSanBong;
    List<SanBong> sanBongList;
    SanBongApdapter apdapter;
    String urlgetdatasanbong="http://192.168.0.99:8080/DoanMonHoc/getdatasanbong.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_san_bong);
        anhxasanbong();
        apdapter=new SanBongApdapter(this,R.layout.dong_sanbanh,sanBongList);
        lvSanBong.setAdapter(apdapter);
        getdataSanBay(urlgetdatasanbong);
        lvSanBong.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            }
        });
    }

    private void anhxasanbong() {
        lvSanBong=(ListView) findViewById(R.id.listviewSanBong);
        sanBongList=new ArrayList<>();
    }
    private void getdataSanBay(String url){
        RequestQueue requestQueue=Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i=0;i<response.length();i++){
                    try {
                        JSONObject object=response.getJSONObject(i);
                        sanBongList.add(new SanBong(
                                object.getInt("IdSan"),
                                object.getString("TenSan"),
                                object.getString("LoaiSan"),
                                object.getString("DonGiaSan"+""),
                                object.getString("HinhSan")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                apdapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonArrayRequest);
    }
}
