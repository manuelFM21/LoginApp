package com.example.loginapp;

public class User {
    int id;
    String nombre;
    String email;
    String DNI;
    String contraseña;

    public User(int id, String nombre, String email, String DNI, String contraseña){
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.DNI = DNI;
        this.contraseña = contraseña;
    }

    @Override
    public String toString(){
        return "Nombre: "+nombre+";\nEmail: "+email+";\nDNI: "+DNI+";\nContraseña: "+contraseña+";";
    }
}

