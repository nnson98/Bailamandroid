package com.example.doanmonhoc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    Button btnLogin,btnDangki;
    EditText editTextUser,editTextPass;
    String urlkiemtraUser="http://192.168.1.7/DoanMonHoc/kiemtradangnhap.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin=(Button) findViewById(R.id.btnDangNhap);
        btnDangki=(Button) findViewById(R.id.btnSignup);
        editTextUser=(EditText) findViewById(R.id.edtUser) ;
        editTextPass=(EditText) findViewById(R.id.edtPass) ;
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = editTextUser.getText().toString();
                String pass = editTextPass.getText().toString();
                if (user.isEmpty() && pass.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Hay dien thong tin day du", Toast.LENGTH_SHORT).show();

                } else if (user.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Nhap Email", Toast.LENGTH_SHORT).show();
                } else if (pass.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Nhap password", Toast.LENGTH_SHORT).show();
                } else if (user.trim().length()>0) {
                    startActivity(new Intent(MainActivity.this,TrangChu.class));
                    finish();
                }else{

                }
            }
        });
        btnDangki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,DangKiActivity.class));
                finish();
            }
        });

    }
    private void Kiemtrauser(String url){
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.trim().equals("success")){
                    Toast.makeText(MainActivity.this, "Dang nhap thanh cong", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this,TrangChu.class));
                    finish();
                }
                else{
                    Toast.makeText(MainActivity.this, "Ten dang nhap hoac mat khau khong dung", Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Loi qua trinh", Toast.LENGTH_SHORT).show();
            }
        }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("userKH",editTextUser.getText().toString().trim());
                params.put("passKH",editTextPass.getText().toString().trim());
                return params;

            }
        };
        requestQueue.add(stringRequest);
    }
}
