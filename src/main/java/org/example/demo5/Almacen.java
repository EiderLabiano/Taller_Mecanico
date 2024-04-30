package org.example.demo5;

public class Almacen {
public  int ID_Almacen;
public  String  componente;
public  int stock;


    public int getID_Almacen() {
        return ID_Almacen;
    }

    public void setID_Almacen(int ID_Almacen) {
        this.ID_Almacen = ID_Almacen;
    }

    public String getComponente() {
        return componente;
    }

    public void setComponente(String nombrePieza) {
        this.componente = nombrePieza;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

}

