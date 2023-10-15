import java.util.Scanner;

/**
 * Alumno: Joel Antonio Jaquez Lopez
 * Fecha de creacion: 14/10/2023
 * Ultima fehca de actualizacion: 14/10/2023
 * Clase: Programacion Orientada a Objetos
 * Ejercicio 5: Polimorfismo via Herencia
 * 
 * Clase principal que gestiona la interacción con el usuario para administrar jugadores de voleibol.
 */
public class Main {
    public static void main(String[] args) {
        // Crear gestor de jugadores y scanner para la entrada del usuario
        GestorJugador gestor = new GestorJugador();
        Scanner scanner = new Scanner(System.in);

        // Cargar jugadores desde CSV al iniciar el programa
        gestor.cargarDeCSV("jugadores.csv");

        // Si el CSV está vacío, se crearán algunos jugadores predeterminados con nombre, país y posición.
        // Adición de jugadores:
        if (gestor.cantidadJugadores() == 0) {
            Libero jugador1 = new Libero("Juan", "Argentina", 0, 0, 0, 0);
            gestor.agregarJugador(jugador1);

            Pasador jugador2 = new Pasador("Mario", "Brasil", 0, 0, 0, 0, 0);
            gestor.agregarJugador(jugador2);

            OpuestoAuxiliar jugador3 = new OpuestoAuxiliar("Carlos", "México",  0, 0, 0, 0, 0, 0);
            gestor.agregarJugador(jugador3);

            OpuestoAuxiliar jugador4 = new OpuestoAuxiliar("Pedro", "España", 0, 0, 0, 0, 0, 0);
            gestor.agregarJugador(jugador4);

            Libero jugador5 = new Libero("Lucas", "Portugal", 0, 0, 0, 0);
            gestor.agregarJugador(jugador5);

            Pasador jugador6 = new Pasador("Mateo", "Uruguay", 0, 0, 0, 0, 0);
            gestor.agregarJugador(jugador6);

            OpuestoAuxiliar jugador7 = new OpuestoAuxiliar("Alejandro", "Chile", 0, 0, 0, 0, 0, 0);
            gestor.agregarJugador(jugador7);

            OpuestoAuxiliar jugador8 = new OpuestoAuxiliar("Diego", "Colombia", 0, 0, 0, 0, 0, 0);
            gestor.agregarJugador(jugador8);

            Libero jugador9 = new Libero("Ricardo", "Venezuela", 0, 0, 0, 0);
            gestor.agregarJugador(jugador9);

            Pasador jugador10 = new Pasador("Fernando", "Bolivia", 0, 0, 0, 0, 0);
            gestor.agregarJugador(jugador10);
    }

        boolean continuar = true;
        while (continuar) {
             // Mostrar menú al usuario
            System.out.println("\n---- Menú ----");
            System.out.println("1. Ingresar estadísticas para un jugador");
            System.out.println("2. Eliminar jugador");
            System.out.println("3. Buscar jugador");
            System.out.println("4. Mostrar todos los jugadores");
            System.out.println("5. Guardar jugadores en CSV");
            System.out.println("6. Mostrar top jugadores por efectividad");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                     // Ingresar estadísticas para un jugador
                    System.out.println("\n---- Ingresar estadísticas ----");
                    System.out.print("Ingrese el nombre del jugador: ");
                    String nombre = scanner.nextLine();

                    Jugador jugadorSeleccionado = gestor.buscarJugador(nombre);
                    if (jugadorSeleccionado != null) {
                        System.out.print("Ingrese la cantidad de errores: ");
                        int errores = scanner.nextInt();
                        jugadorSeleccionado.setErrores(errores);

                        System.out.print("Ingrese la cantidad de aces: ");
                        int aces = scanner.nextInt();
                        jugadorSeleccionado.setAces(aces);

                        System.out.print("Ingrese el total de servicios: ");
                        int totalServicios = scanner.nextInt();
                        jugadorSeleccionado.setTotalServicios(totalServicios);

                        switch (jugadorSeleccionado.getPosicion()) {
                            case "Libero":
                                System.out.print("Ingrese el número de recibos efectivos: ");
                                int recibos = scanner.nextInt();
                                ((Libero) jugadorSeleccionado).setRecibosEfectivos(recibos);
                                break;
                            case "Pasador":
                                System.out.print("Ingrese el número de pases: ");
                                int pases = scanner.nextInt();
                                System.out.print("Ingrese el número de fintas efectivas: ");
                                int fintas = scanner.nextInt();
                                ((Pasador) jugadorSeleccionado).setPases(pases);
                                ((Pasador) jugadorSeleccionado).setFintasEfectivas(fintas);
                                break;
                            case "OpuestoAuxiliar":
                                System.out.print("Ingrese el número de ataques: ");
                                int ataques = scanner.nextInt();
                                System.out.print("Ingrese el número de bloqueos efectivos: ");
                                int bloqueosEfectivos = scanner.nextInt();
                                System.out.print("Ingrese el número de bloqueos fallidos: ");
                                int bloqueosFallidos = scanner.nextInt();
                                ((OpuestoAuxiliar) jugadorSeleccionado).setAtaques(ataques);
                                ((OpuestoAuxiliar) jugadorSeleccionado).setBloqueosEfectivos(bloqueosEfectivos);
                                ((OpuestoAuxiliar) jugadorSeleccionado).setBloqueosFallidos(bloqueosFallidos);
                                break;
                        }
                        
                        System.out.println("Estadísticas actualizadas con éxito.");
                    } else {
                        System.out.println("Jugador no encontrado.");
                    }
                    break;

                case 2:
                    // Eliminar jugador
                    System.out.println("\n---- Eliminar jugador ----");
                    System.out.print("Ingrese el nombre del jugador a eliminar: ");
                    nombre = scanner.nextLine();
                    gestor.eliminarJugador(nombre);
                    System.out.println("Jugador eliminado (si existía).");
                    break;

                case 3:
                    // Buscar jugador
                    System.out.println("\n---- Buscar jugador ----");
                    System.out.print("Ingrese el nombre del jugador a buscar: ");
                    nombre = scanner.nextLine();
                    Jugador encontrado = gestor.buscarJugador(nombre);
                    if (encontrado != null) {
                        System.out.println("Jugador encontrado:");
                        System.out.println("Nombre: " + encontrado.getNombre());
                        System.out.println("País: " + encontrado.getPais());
                        System.out.println("Posición: " + encontrado.getPosicion());
                    } else {
                        System.out.println("Jugador no encontrado.");
                    }
                    break;

                case 4:
                    // Mostrar todos los jugadores
                    System.out.println("\n---- Mostrar todos los jugadores ----");
                    gestor.mostrarTodosLosJugadores();
                    break;

                case 5:
                    // Guardar jugadores en CSV
                    gestor.guardarEnCSV("jugadores.csv");
                    System.out.println("Jugadores guardados en el archivo CSV.");
                    break;

                case 6:
                    // Mostrar top jugadores por efectividad dependiendo de la posicion
                    System.out.println("\n---- Mostrar top jugadores por efectividad ----");
                    gestor.mostrarTopJugadoresPorEfectividad();
                    break;

                case 7:
                    // Salir del programa
                    continuar = false;
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }

        // Guardar jugadores en el CSV antes de salir
        gestor.guardarEnCSV("jugadores.csv");

         // Cerrar scanner
        scanner.close();
    }
}
