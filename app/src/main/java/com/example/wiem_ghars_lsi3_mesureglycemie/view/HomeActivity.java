package com.example.wiem_ghars_lsi3_mesureglycemie.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.wiem_ghars_lsi3_mesureglycemie.R;
import com.example.wiem_ghars_lsi3_mesureglycemie.controller.LoginController;

public class HomeActivity extends AppCompatActivity {
    private Button btnConsultation;
    //TP6
    private EditText etUserName;
    private LoginController loginController;
    private EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
        etUserName.setText(loginController.getUserName());
        etPassword.setText(loginController.getPassword());
        btnConsultation=(Button) findViewById(R.id.btnConsultation);
        btnConsultation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    private void init()
    {
         loginController = com.example.wiem_ghars_lsi3_mesureglycemie.controller.LoginController.getInstance(HomeActivity.this);
        btnConsultation =(Button)
    }
}