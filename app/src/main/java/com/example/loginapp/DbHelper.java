package com.example.loginapp;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NOMBRE = "agenda.db";
    public static  final String TABLE_USUARIOS = "t_contactos";

    public DbHelper(@Nullable Context context){
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqlLiteDatabase){
        sqlLiteDatabase.execSQL("CREATE TABLE " + TABLE_USUARIOS + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "nombre TEXT UNIQUE NOT NULL,"+
                "email TEXT NOT NULL,"+
                "DNI TEXT UNIQUE NOT NULL,"+
                "contraseña TEXT NOT NULL)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqlLiteDatabase, int i, int i1){
        sqlLiteDatabase.execSQL("DROP TABLE " + TABLE_USUARIOS);
        onCreate(sqlLiteDatabase);
    }
}
