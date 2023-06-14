package com.example.cycle_saathi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPageActivity extends AppCompatActivity {

    EditText uNameET, passWordET;

    Button loginBtn, regisBtn, clearBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        uNameET = findViewById(R.id.uNameET);
        passWordET = findViewById(R.id.passWordET);

        loginBtn = findViewById(R.id.logInBtn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname = uNameET.getText().toString();
                String pass = passWordET.getText().toString();
                Toast.makeText(LoginPageActivity.this, "Username = " + uname + " Password = "+ pass, Toast.LENGTH_LONG).show();
                //VALIDATION BAKKI
                Intent intent = new Intent(LoginPageActivity.this, HomePageActivity.class);
                startActivity(intent);
            }
        });

        clearBtn = findViewById(R.id.clearBtn);
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uNameET.setText("");
                passWordET.setText("");
            }
        });

        regisBtn = findViewById(R.id.regisBtn);
        regisBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginPageActivity.this, RegistrationPageActivity.class);
                startActivity(intent);
            }
        });
    }
}