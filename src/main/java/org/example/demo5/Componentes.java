package org.example.demo5;

public class Componentes {
    public String ID_Componente;
    public  String nombre;
    public double precio;
    public int stock;
    public String modelo;

    public String getID_Componente() {
        return ID_Componente;
    }

    public void setID_Componente(String ID_Componente) {
        this.ID_Componente = ID_Componente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
