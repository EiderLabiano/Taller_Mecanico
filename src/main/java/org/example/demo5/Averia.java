package org.example.demo5;

public class Averia {
    private int IdPedido;
    private String Nombre;
    private String apellido;
    private String direccion;
    private String componentes;
    private int precio;

    public int getIdPedido() {
        return IdPedido;
    }

    public void setIdPedido(int idPedido) {
        IdPedido = idPedido;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getComponentes() {
        return componentes;
    }

    public void setComponentes(String componentes) {
        this.componentes = componentes;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Averia(int id, String n, String a, String d, String c, int valor)
    {
        IdPedido = id;
        Nombre = n;
        apellido = a;
        direccion = d;
        componentes = c;
        precio = valor;
    }
}
