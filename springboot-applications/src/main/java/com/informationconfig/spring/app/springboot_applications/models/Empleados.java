package com.informationconfig.spring.app.springboot_applications.models;

public class Empleados {
    private String nombre, apellido, email, puesto;
    private int edad, salario, telefono, id;

    public Empleados(String nombre, String apellido, String email, String puesto, int edad, int salario, int telefono, int id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.puesto = puesto;
        this.edad = edad;
        this.salario = salario;
        this.telefono = telefono;
        this.id = id;   
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPuesto() {
        return puesto;
    }
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public int getSalario() {
        return salario;
    }
    public void setSalario(int salario) {
        this.salario = salario;
    }
    public int getTelefono() {
        return telefono;
    }
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    
}
