package com.example.loginapp;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Delete extends AppCompatActivity {
    Button btnBack, btnDelete;
    EditText etUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        btnBack = findViewById(R.id.btnBackL);
        btnDelete = findViewById(R.id.btndelete);
        etUser = findViewById(R.id.eTUserL);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Delete.this, menuPrincipal.class);
                startActivity(intent);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!etUser.getText().toString().equals("")){
                    DbUsuarios db= new DbUsuarios(Delete.this);
                    if(etUser.getText().toString().equals("")){
                        Toast.makeText(Delete.this, "ERROR AL BORRAR USUARIO", Toast.LENGTH_LONG).show();
                    }else{
                        int id = db.deleteUser(etUser.getText().toString());
                        if(id > 0){
                            Toast.makeText(Delete.this, "USUARIO BORRADO", Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(Delete.this, "USUARIO NO BORRADO", Toast.LENGTH_LONG).show();
                        }
                    }
                }else{
                    Toast.makeText(Delete.this, "LLENA LOS CAMPOS", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}