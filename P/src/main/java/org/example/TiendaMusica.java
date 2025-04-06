package org.example;

import java.util.*;

public class TiendaMusica {
    private List<Artista> artistas = new ArrayList<>();
    private List<Disco> discos = new ArrayList<>();
    private int contadorArtistas = 1;

    //agregar artista
    public void agregarArtista(Artista artista) {
        artistas.add(artista);
    }
    //agregar un disco
    public void agregarDisco(Disco disco) {
        discos.add(disco);
    }
   // punto 5
    public void registrarVenta(String tituloDisco, int cantidad) {
        boolean encontrado = false;
        for (Disco d : discos) {
            if (d.getTitulo().equalsIgnoreCase(tituloDisco)) {
                d.registrarVenta(cantidad);
                System.out.println("✅ Venta registrada correctamente.");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("⚠️ Disco no encontrado.");
        }
    }
    //punto 4
    public void mostrarDiscosPopulares(int umbral) {
        System.out.println("\n🎵 Discos con más de " + umbral + " unidades vendidas:");
        discos.stream()
                .filter(d -> d.getVentasTotales() > umbral)
                .forEach(Disco::mostrarDetalles);
    }
    //punto 3
    public void artistaConMasVentas() {
        Optional<Artista> top = artistas.stream()
                .max(Comparator.comparingInt(Artista::getVentasTotales));

        if (top.isPresent()) {
            System.out.println("👑 Artista con más ventas: ");
            System.out.println(top.get());
        } else {
            System.out.println("⚠️ No hay artistas registrados aún.");
        }
    }

    // Métodos auxiliares para menú dinámico

    public int generarIdArtista() {
        return contadorArtistas++;
    }

    public Artista buscarArtistaPorId(int id) {
        for (Artista a : artistas) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }
    //muestra los artistas (cunado se selecciona un disco )
    public void mostrarArtistas() {
        System.out.println("\n🎶 Lista de Artistas:");
        for (Artista a : artistas) {
            System.out.println("ID: " + a.getId() + " | Nombre: " + a.getNombre());
        }
    }
}