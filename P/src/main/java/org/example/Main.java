package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // aqui la entrada de datos
        TiendaMusica tienda = new TiendaMusica();
        int opcion;

        //menu lo nuevo que agregue
        do {
            System.out.println("\n📀 SISTEMA DE TIENDA DE MÚSICA 📀");
            System.out.println("1. Registrar nuevo artista");
            System.out.println("2. Registrar nuevo disco");
            System.out.println("3. Registrar venta de un disco");
            System.out.println("4. Mostrar discos con más de X unidades vendidas");
            System.out.println("5. Mostrar artista con más ventas");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    // punto 1 registrar al artistab
                    System.out.print("Nombre del artista: ");
                    String nombre = scanner.nextLine();
                    int id = tienda.generarIdArtista(); // Auto ID
                    tienda.agregarArtista(new Artista(id, nombre));
                    System.out.println("🎤 Artista registrado exitosamente.");
                    break;

                case 2:
                    //punto 2 registro del disco
                    tienda.mostrarArtistas();
                    System.out.print("ID del artista al que pertenece el disco: ");
                    int artistaId = scanner.nextInt();
                    scanner.nextLine(); // limpiar buffer

                    Artista artista = tienda.buscarArtistaPorId(artistaId);
                    if (artista == null) {
                        System.out.println("⚠️ Artista no encontrado.");
                        break;
                    }

                    System.out.print("Título del disco: ");
                    String titulo = scanner.nextLine();
                    tienda.agregarDisco(new Disco(artista, titulo));
                    System.out.println("💿 Disco registrado correctamente.");
                    break;

                case 3:
                    //punto 5 regidtro de venta
                    System.out.print("Título del disco vendido: ");
                    String tituloVenta = scanner.nextLine();
                    System.out.print("Cantidad vendida: ");
                    int cantidad = scanner.nextInt();
                    scanner.nextLine();
                    tienda.registrarVenta(tituloVenta, cantidad);
                    break;

                case 4:
                    //punto 4 mostrar X registros
                    System.out.print("¿Mostrar discos con más de cuántas unidades?: ");
                    int umbral = scanner.nextInt();
                    scanner.nextLine();
                    tienda.mostrarDiscosPopulares(umbral);
                    break;

                case 5:
                    //punto 3 mostrar artista con mas ventas 
                    tienda.artistaConMasVentas();
                    break;

                case 6:
                    System.out.println("👋 ¡Gracias por usar el sistema!");
                    break;

                default:
                    System.out.println("❌ Opción inválida. Intenta nuevamente.");
            }

        } while (opcion != 6);

        scanner.close();
    }
}