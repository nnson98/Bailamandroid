package com.example.doanmonhoc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
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

public class ThongTinCaNhanActivity extends AppCompatActivity {
    ListView lvTT;
    List<ThongTinCaNhan> thongTinCaNhanList;
    ThongTinCaNhanAdapter adapter;
    String urlgetdatatt="http://10.107.228.46/DoanMonHoc/getdatathongtin.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_ca_nhan);
        anhxa();
        adapter=new ThongTinCaNhanAdapter(this,R.layout.dong_thongtincanhan,thongTinCaNhanList);
        lvTT.setAdapter(adapter);
        GetdataThogntIN(urlgetdatatt);
    }

    private void anhxa() {
        lvTT=(ListView) findViewById(R.id.lvThongTinCaNhan);
        thongTinCaNhanList=new ArrayList<>();
    }

    private void GetdataThogntIN(String url){
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i=0;i<response.length();i++){
                    try {
                        JSONObject object=response.getJSONObject(i);
                        thongTinCaNhanList.add(new ThongTinCaNhan(
                                object.getString("NameKH"),
                                object.getString("PhoneKH")
                                ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }

        });
        requestQueue.add(jsonArrayRequest);
    }

}
