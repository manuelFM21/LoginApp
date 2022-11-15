package com.example.loginapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DbUsuarios extends DbHelper {

    Context context;

    public DbUsuarios(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarUser(String nombre, String email, String DNI, String contraseña){
        long id = 0;

        try{
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("nombre", nombre);
            values.put("email", email);
            values.put("DNI", DNI);
            values.put("contraseña", contraseña);
            id = db.insert(TABLE_USUARIOS, null, values);

        }catch(Exception e){
            e.toString();
        }
        return id;
    }
    public Boolean checkUser(String nombre, String contraseña){
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_USUARIOS + " WHERE (nombre = '"+nombre+"')"+"AND (contraseña = '"+contraseña+"');";
        Cursor data = db.rawQuery(query, null);
        if(data.getCount()>0){
            data.close();
            return true;
        }else{
            data.close();
            return false;
        }
    }

    public int deleteUser(String nombre){
        int id = 0;
        try{
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            id = db.delete(TABLE_USUARIOS, "nombre ='"+nombre+"'",null);
        }catch(Exception e){
            e.toString();
        }
        return id;
    }

    public int updateUser(String nombre, String email, String DNI, String contraseña){
        int id = 0;
        try{
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("nombre", nombre);
            values.put("email", email);
            values.put("DNI", DNI);
            values.put("contraseña", contraseña);
            id = db.update(TABLE_USUARIOS, values, "nombre = '"+nombre+"'",null);
        }catch(Exception e){
            e.toString();
        }
        return id;
    }

    public ArrayList<User> ListUser(){
        ArrayList<User> users = new  ArrayList<User> (10);
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_USUARIOS;
        Cursor data = db.rawQuery(query, null);
        if (data.getCount() > 0){
            data.moveToFirst();
            do{
                int id = data.getInt(0);
                String nombre = data.getString(1);
                String email = data.getString(2);
                String DNI = data.getString(3);
                String contraseña = data.getString(4);

                User user = new User(id , nombre,email,DNI,contraseña);
                users.add(user);
            } while( data.moveToNext() );
        }
        return users;
    }
}
