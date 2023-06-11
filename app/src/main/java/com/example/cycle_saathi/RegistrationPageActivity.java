package com.example.cycle_saathi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationPageActivity extends AppCompatActivity {


    EditText fNameET, addrET, emailET, contET, uNameET, passWordET, rePassWordET;

    String fNameS, addrS, emailS, contS, uNameS, passWordS, rePassWordS;
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
                fNameS = fNameET.getText().toString();
                addrS = addrET.getText().toString();
                emailS = emailET.getText().toString();
                contS = contET.getText().toString();
                uNameS = uNameET.getText().toString();
                passWordS = passWordET.getText().toString();
                rePassWordS = rePassWordET.getText().toString();
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
}