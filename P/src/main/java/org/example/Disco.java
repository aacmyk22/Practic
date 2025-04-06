package org.example;

//representa un disco y el artista
public class Disco {
    //atributos
    private Artista artista;
    private String titulo;
    private int ventasTotales;

    //constructor
    public Disco(Artista artista, String titulo) {
        this.artista = artista;
        this.titulo = titulo;
        this.ventasTotales = 0;
    }
    //getters
    public Artista getArtista() { return artista; }
    public String getTitulo() { return titulo; }
    public int getVentasTotales() { return ventasTotales; }

    //metodo para registrar las ventas punto 4 y 5
    // actualiza ventas del disco y tambien del artista
    public void registrarVenta(int cantidad) {
        ventasTotales += cantidad;  //ventas disco
        artista.sumarVentas(cantidad); //ventas artista
        //actualiza las ventas del disco si es necesario
        if (ventasTotales > artista.getVentasTotales()) {
            artista.setDiscoMasVendido(titulo);
        }
    }
    //metodo para mostrar los detalles del disco punto 2
    public void mostrarDetalles() {
        System.out.println("Disco: " + titulo + " | Artista: " + artista.getNombre() + " | Ventas: " + ventasTotales);
    }
}