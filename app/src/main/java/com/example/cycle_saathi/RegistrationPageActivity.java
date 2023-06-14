package com.example.cycle_saathi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;

public class RegistrationPageActivity extends AppCompatActivity {


    EditText fNameET, addrET, emailET, contET, uNameET, passWordET, rePassWordET;

    //String fNameS, addrS, emailS, contS, uNameS, passWordS, rePassWordS;
    Button regisBtn, loginBtn, clearBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);

        fNameET = findViewById(R.id.fNameET);
        addrET = findViewById(R.id.addressET);
        emailET = findViewById(R.id.emailET);
        contET = findViewById(R.id.contactET);
        uNameET = findViewById(R.id.uNameET);
        passWordET = findViewById(R.id.passWordET);
        rePassWordET = findViewById(R.id.rePassWordET);


        regisBtn = findViewById(R.id.registerBtn);
        regisBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
                Toast.makeText(RegistrationPageActivity.this, "Registered!! Now You can Login.", Toast.LENGTH_SHORT).show();
                Intent in = new Intent(RegistrationPageActivity.this, LoginPageActivity.class);
                startActivity(in);
            }
        });

        clearBtn = findViewById(R.id.clearBtn);
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fNameET.setText("");
                addrET.setText("");
                emailET.setText("");
                contET.setText("");
                uNameET.setText("");
                passWordET.setText("");
                rePassWordET.setText("");
            }
        });

        loginBtn = findViewById(R.id.goToLogin);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(RegistrationPageActivity.this, LoginPageActivity.class);
                startActivity(in);
            }
        });
    }
    private void registerUser() {
        RequestQueue rQue = Volley.newRequestQueue(RegistrationPageActivity.this);
        String url  = "http://192.168.1.72/cycle_sathii_api/register.php";
        StringRequest sReq = new StringRequest(Request.Method.POST,url,new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(RegistrationPageActivity.this,"User Registered", Toast.LENGTH_LONG);
                Intent in = new Intent(RegistrationPageActivity.this, LoginPageActivity.class);
                startActivity(in);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Display Response Error
                Log.e("RegistrationActivity", "Error "+error.toString());
            }
        }){
            @Override
            protected HashMap<String,String> getParams(){
                HashMap<String,String>params = new HashMap<>();
                params.put("name",fNameET.getText().toString());
                params.put("address",addrET.getText().toString());
                params.put("email",emailET.getText().toString());
                params.put("contact",contET.getText().toString());
                params.put("uname",uNameET.getText().toString());
                params.put("pwd",passWordET.getText().toString());
                params.put("repwd",rePassWordET.getText().toString());
                return params;
            }
        };
        rQue.add(sReq);
    }
}