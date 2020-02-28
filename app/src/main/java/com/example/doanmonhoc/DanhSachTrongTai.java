package com.example.doanmonhoc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

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

public class DanhSachTrongTai extends AppCompatActivity {
    ListView lvTrongTai;
    List<TrongTai> trongTaiList;
    TrongTaiApdapter apdapter;
    String urlgetdatatt="http://192.168.0.99:8080/DoanMonHoc/getdatatt.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_trong_tai);
        Anhxa();
        apdapter=new TrongTaiApdapter(this,R.layout.dong_trongtai,trongTaiList);
        lvTrongTai.setAdapter(apdapter);
        GetDataTT(urlgetdatatt);

    }

    private void Anhxa() {
        lvTrongTai=(ListView) findViewById(R.id.lvTrongTai);
        trongTaiList=new ArrayList<>();
    }
    private void GetDataTT(String url){
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i=0 ; i<response.length();i++){
                    try {
                        JSONObject object=response.getJSONObject(i);
                            trongTaiList.add(new TrongTai(
                                   object.getInt("IdTT"),
                                    object.getString("HoTenTT"),
                                    object.getString("TuoiTT"),
                                    object.getString("KNTT"),
                                    object.getString("HinhTT"),
                                    object.getString("DonGia")
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
