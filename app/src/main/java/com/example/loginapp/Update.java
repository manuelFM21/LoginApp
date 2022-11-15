package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Update extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        Button btnUpdate, btnBack;
        TextView etEmail, etUser, etPass, etDNI;


        etEmail = findViewById(R.id.eTEmail);
        etPass = findViewById(R.id.eTPass);
        etUser = findViewById(R.id.eTUser);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnBack = findViewById(R.id.btnBack);
        etDNI = findViewById(R.id.etDNI);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!etEmail.getText().toString().equals("") && !etPass.getText().toString().equals("") && !etUser.getText().toString().equals("")  && !etDNI.getText().toString().equals("")){
                    DbUsuarios dbUsuarios = new DbUsuarios(Update.this);
                    long id = dbUsuarios.updateUser(etUser.getText().toString(), etEmail.getText().toString(), etDNI.getText().toString(), etPass.getText().toString());

                    if(id > 0){
                        Toast.makeText(Update.this, "REGISTRO ACTUALIZADO", Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(Update.this, "ERROR AL ACTUALIZAR REGISTRO", Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(Update.this, "LLENA LOS CAMPOS", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Update.this, menuPrincipal.class);
                startActivity(intent);
            }
        });
    }
}
