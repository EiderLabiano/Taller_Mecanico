package org.example.demo5;

public class Componentes {
    private int ID_Componente;
    private String nombre;
    private int stock;
    private String modelo;
    private int precio;

    public Componentes(int id, String nombre, String modelo, int stock, int precio) {
        this.ID_Componente = id;
        this.nombre = nombre;
        this.stock = stock;
        this.modelo = modelo;
        this.precio = precio;
    }


    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getID_Componente() {
        return ID_Componente;
    }

    public void setID_Componente(int ID_Componente) {
        this.ID_Componente = ID_Componente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
