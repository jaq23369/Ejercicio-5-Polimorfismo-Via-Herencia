import java.util.Collections;
import java.io.*;
import java.util.Comparator;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Alumno: Joel Antonio Jaquez Lopez
 * Fecha de creacion: 14/10/2023
 * Ultima fehca de actualizacion: 14/10/2023
 * Clase: Programacion Orientada a Objetos
 * Ejercicio 5: Polimorfismo via Herencia
 * 
 * Gestiona un conjunto de jugadores de voleibol.
 * Proporciona funcionalidad para agregar, eliminar, buscar, guardar y cargar jugadores.
 */
public class GestorJugador {
    
    /** Lista de jugadores gestionados. */
    private ArrayList<Jugador> jugadores;

    /**
     * Constructor que inicializa un nuevo gestor de jugadores.
     */
    public GestorJugador() {
        this.jugadores = new ArrayList<>();
    }

    /**
     * Agrega un jugador a la lista.
     *
     * @param jugador Jugador a agregar.
     */
    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    /**
     * Elimina un jugador de la lista por su nombre.
     *
     * @param nombre Nombre del jugador a eliminar.
     */
    public void eliminarJugador(String nombre) {
        jugadores.removeIf(jugador -> jugador.getNombre().equals(nombre));
    }

    /**
     * Busca un jugador en la lista por su nombre.
     *
     * @param nombre Nombre del jugador a buscar.
     * @return El jugador encontrado o null si no se encuentra.
     */
    public Jugador buscarJugador(String nombre) {
        for (Jugador jugador : jugadores) {
            if (jugador.getNombre().equals(nombre)) {
                return jugador;
            }
        }
        return null;  // retorna null si no encuentra el jugador
    }

    /**
     * Muestra todos los jugadores en la lista.
     */
    public void mostrarTodosLosJugadores() {
        for (Jugador jugador : jugadores) {
            System.out.println(jugador.getNombre() + " - " + jugador.getPais());
        }
    }

    /**
     * Guarda todos los jugadores en un archivo CSV.
     *
     * @param rutaArchivo Ruta del archivo CSV donde guardar los jugadores.
     */
    public void guardarEnCSV(String rutaArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            writer.write("Nombre,País,Posición,Rendimiento\n");
            for (Jugador jugador : jugadores) {
                writer.write(jugador.getNombre() + "," + 
                             jugador.getPais() + "," + 
                             jugador.getPosicion() + "," + 
                             jugador.calcularEfectividad() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    /**
     * Carga jugadores desde un archivo CSV.
     *
     * @param rutaArchivo Ruta del archivo CSV de donde cargar los jugadores.
     */
    public void cargarDeCSV(String rutaArchivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                Jugador jugador = new Jugador(datos[0], datos[1], datos[2], Integer.parseInt(datos[3]), 
                                             Integer.parseInt(datos[4]), Integer.parseInt(datos[5]));
                jugadores.add(jugador);
            }
        } catch (IOException e) {
            System.out.println("Error al leer del archivo: " + e.getMessage());
        }
    }

    /**
     * Muestra el top 3 de jugadores por efectividad en una posición específica.
     */
    public void mostrarTopJugadoresPorEfectividad() {
        Scanner scanner = new Scanner(System.in);

        // Ordenar la lista de jugadores por efectividad
        jugadores.sort(Comparator.comparingDouble(Jugador::calcularEfectividad).reversed());

        System.out.print("Introduzca la posición (Libero, Pasador, OpuestoAuxiliar): ");
        String posicion = scanner.nextLine();

        int count = 0;
        for (Jugador jugador : jugadores) {
            // Comprobar si el jugador pertenece a la posición introducida
            if (jugador.getPosicion().equalsIgnoreCase(posicion)) {
                System.out.println(jugador.getNombre() + " - " + jugador.calcularEfectividad() + "%");
                count++;
                if (count == 3) break;  // Mostrar solo el top 3
            }
        }
        if (count == 0) {
            System.out.println("No hay jugadores en la posición introducida.");
        }
    }

    /**
     * Ordena los jugadores por efectividad.
     */
    public void ordenarJugadoresPorEfectividad() {
        jugadores.sort(Comparator.comparingDouble(Jugador::calcularEfectividad).reversed());
    }

    /**
     * Devuelve la cantidad total de jugadores en la lista.
     *
     * @return Cantidad total de jugadores.
     */
    public int cantidadJugadores() {
        return jugadores.size();
    }
}

