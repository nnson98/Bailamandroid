package com.example.doanmonhoc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

public class DanhSachNuocUong extends AppCompatActivity {
    ListView lvNC;
    List<Nuoc> nuocList;
    NuocApdapter apdapter;
    String urlgetdatanuoc="http://192.168.0.99:8080/DoanMonHoc/getdatanuoc.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_nuoc_uong);
        anhxa();

            apdapter=new NuocApdapter(this,R.layout.dong_nuocuong,nuocList);
            lvNC.setAdapter(apdapter);
        getdatanuoc(urlgetdatanuoc);


    }

    private void anhxa() {
        lvNC=(ListView) findViewById(R.id.lvNuocUong);
        nuocList=new ArrayList<>();
    }
    private void getdatanuoc(String url){
        RequestQueue requestQueue=Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i=0;i<response.length();i++){
                    try {
                        JSONObject object=response.getJSONObject(i);
                        nuocList.add(new Nuoc(
                                 object.getInt("IdNuoc"),
                                 object.getString("TenNuoc"),
                                object.getString("DonGia"),
                                object.getString("HinhNuoc")

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
