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

public class DangKiActivity extends AppCompatActivity {
    EditText editTextUser,editTextPass,editTextName,editTextPhone;
    Button btnDangKi;
    String urlthemuser="http://192.168.1.7/DoanMonHoc/insertuser.php";
    String urlkiemtrausercochua="http://192.168.1.7/DoanMonHoc/kiemtrauser.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ki);
        anhxa();
        btnDangKi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String user=editTextUser.getText().toString().trim();
            String pass=editTextPass.getText().toString().trim();
            String name=editTextName.getText().toString().trim();
            String phone=editTextPhone.getText().toString().trim();
                if(name.isEmpty() && user.isEmpty() && pass.isEmpty() &&phone.isEmpty()){
                    Toast.makeText(DangKiActivity.this, "Hay dien day du thong tin", Toast.LENGTH_SHORT).show();
                }else if(name.isEmpty()){
                    Toast.makeText(DangKiActivity.this, "Hay dien vao ten cua ban", Toast.LENGTH_SHORT).show();
                }else if(user.isEmpty()){
                    Toast.makeText(DangKiActivity.this, "Hay dien vao user cua ban", Toast.LENGTH_SHORT).show();
                }else if(pass.isEmpty()) {
                    Toast.makeText(DangKiActivity.this, "Hay dien vao password cua ban", Toast.LENGTH_SHORT).show();
                }else  if(phone.isEmpty()){
                    Toast.makeText(DangKiActivity.this, "Hãy điền số điện thoại", Toast.LENGTH_SHORT).show();
                }
                else if (isValidEmail(user) && name.trim().length()>0&& pass.trim().length()>0 && user.trim().length()>0&&kiemtradodaiphone(phone)){
                    kiemtrausercochua(urlkiemtrausercochua);
                }
            }
        });
    }

    private void anhxa() {
        editTextUser=(EditText) findViewById(R.id.edtEmail);
        editTextPass=(EditText) findViewById(R.id.editPass);
        editTextName=(EditText) findViewById(R.id.edtName);
        editTextPhone=(EditText) findViewById(R.id.editPhone);
        btnDangKi=(Button) findViewById(R.id.btnDangKi);

    }
    private  void Themuser(String url){
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.trim().equals("success")){

                }else
                {
                    Toast.makeText(DangKiActivity.this, "Them that bai", Toast.LENGTH_SHORT).show();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(DangKiActivity.this, "Loi qua trinh", Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params =new HashMap<>();
                params.put("userKH",editTextUser.getText().toString().trim());
                params.put("passKH",editTextPass.getText().toString().trim());
                params.put("nameKH",editTextName.getText().toString().trim());
                params.put("phoneKH",editTextPhone.getText().toString().trim());
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
    private void kiemtrausercochua(String url){
        RequestQueue requestQueue=Volley.newRequestQueue(this);
        StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.trim().equals("success")){
                    Toast.makeText(DangKiActivity.this, "Dang ki thanh cong", Toast.LENGTH_SHORT).show();
                    Themuser(urlthemuser);
                    startActivity(new Intent(DangKiActivity.this,MainActivity.class));
                    finish();
                }else {
                    Toast.makeText(DangKiActivity.this, "Trung user", Toast.LENGTH_SHORT).show();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(DangKiActivity.this, "Loi ket noi", Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params =new HashMap<>();
                params.put("userKH",editTextUser.getText().toString().trim());
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    private boolean isValidEmail(String target ){
        if(target.matches("[a-zA-Z0-9._-]+@[a-z]+.[a-z]+"))
            return true;
        else
        {
            Toast.makeText(this, "email bi sai dinh dang", Toast.LENGTH_SHORT).show();
        }
        return false;
    }
    private boolean kiemtradodaiphone(String phone){
        if(phone.trim().length()<11){
            return true;
        }else{
            Toast.makeText(this, "Dinh dang phone khong dung", Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}
