package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class UserMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_menu);

        Button btnUser, btnBack;
        ListView Listview;

        btnUser = findViewById(R.id.buttonUsers);
        btnBack = findViewById(R.id.btnBAck);
        Listview = (ListView)  findViewById(R.id.ListViewID);

        btnUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbUsuarios dbUsuarios = new DbUsuarios(UserMenu.this);
                ArrayList<User> users = dbUsuarios.ListUser();

                if(!users.isEmpty()){
                    Toast.makeText(UserMenu.this, "MOSTRANDO USUARIOS...", Toast.LENGTH_LONG).show();
                    ArrayAdapter<User> adapterUser = new ArrayAdapter<User>(UserMenu.this, android.R.layout.simple_list_item_1, users);
                    Listview.setAdapter(adapterUser);
                }else{
                    Toast.makeText(UserMenu.this, "NO SE  HA PODIDO ACCEDER A LOS USUARIOS", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserMenu.this, menuPrincipal.class);
                startActivity(intent);
            }
        });
    }
}
