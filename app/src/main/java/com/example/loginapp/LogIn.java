package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogIn extends AppCompatActivity {
    Button btnBack, btnLogin;
    EditText etPass, etUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnBack = findViewById(R.id.btnBackL);
        btnLogin = findViewById(R.id.btndelete);
        etPass = findViewById(R.id.eTPassL);
        etUser = findViewById(R.id.eTUserL);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LogIn.this, menuPrincipal.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!etUser.getText().toString().equals("") && !etPass.getText().toString().equals("")){
                    DbUsuarios db= new DbUsuarios(LogIn.this);
                    if(etUser.getText().toString().equals("") || etPass.getText().toString().equals("")){
                        Toast.makeText(LogIn.this, "ERROR AL INICIAR SESION", Toast.LENGTH_LONG).show();
                    }else{
                        boolean check = db.checkUser(etUser.getText().toString(),etPass.getText().toString());
                        if(check){
                            Toast.makeText(LogIn.this, "USUARIO CORRECTO", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(LogIn.this, UserMenu.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(LogIn.this, "USUARIO INCORRECTO", Toast.LENGTH_LONG).show();
                        }
                    }
                }else{
                    Toast.makeText(LogIn.this, "LLENA LOS CAMPOS", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}