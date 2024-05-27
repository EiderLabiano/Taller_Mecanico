package org.example.demo5;

public class Pedidos {
    private int id;
    private String nombreComponente;
    private int cantidad;
    private int precio;

    public Pedidos(String nombre, int cuanto, int precio) {
        this.precio = precio;
        this.nombreComponente = nombre;
        this.cantidad = cuanto;

    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreComponente() {
        return nombreComponente;
    }

    public void setNombreComponente(String nombreComponente) {
        this.nombreComponente = nombreComponente;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
