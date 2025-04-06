package org.example;


//representando el artista estadistica de las ventas
public class Artista {
    //atributos
    private int id;
    private String nombre;
    private String discoMasVendido;
    private int ventasTotales;
    //constructor
    public Artista(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.discoMasVendido = "";
        this.ventasTotales = 0;
    }
    //getters y setters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getDiscoMasVendido() { return discoMasVendido; }
    public int getVentasTotales() { return ventasTotales; }

    public void setDiscoMasVendido(String discoMasVendido) {
        this.discoMasVendido = discoMasVendido;
    }
    //metodo para actualizar estadistica del punto 5
    public void sumarVentas(int cantidad) {
        this.ventasTotales += cantidad;
    }
    //imprimir informacion del artista punto 1
    @Override
    public String toString() {
        return "Artista: " + nombre + " | Ventas Totales: " + ventasTotales + " | Disco más vendido: " + discoMasVendido;
    }
}