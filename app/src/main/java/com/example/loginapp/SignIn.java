package com.example.loginapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignIn extends AppCompatActivity {
    EditText etEmail, etPass, etUser, etDNI;
    Button btnSignIn, btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sigin);

        etEmail = findViewById(R.id.eTEmail);
        etPass = findViewById(R.id.eTPass);
        etUser = findViewById(R.id.eTUser);
        btnSignIn = findViewById(R.id.btnUpdate);
        btnBack = findViewById(R.id.btnBack);
        etDNI = findViewById(R.id.etDNI);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!etUser.getText().toString().equals("") && !etPass.getText().toString().equals("") && !etEmail.getText().toString().equals("")  && !etDNI.getText().toString().equals("")){
                    DbUsuarios dbUsuarios = new DbUsuarios(SignIn.this);
                    long id = dbUsuarios.insertarUser(etUser.getText().toString(), etEmail.getText().toString(), etDNI.getText().toString(), etPass.getText().toString());

                    if(id > 0){
                        Toast.makeText(SignIn.this, "REGISTRO GUARDADO", Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(SignIn.this, "ERROR AL GUARDAR REGISTRO", Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(SignIn.this, "LLENA LOS CAMPOS", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignIn.this, menuPrincipal.class);
                startActivity(intent);
            }
        });
    }
}
