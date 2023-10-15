/**
 * Alumno: Joel Antonio Jaquez Lopez
 * Fecha de creacion: 14/10/2023
 * Ultima fehca de actualizacion: 14/10/2023
 * Clase: Programacion Orientada a Objetos
 * Ejercicio 5: Polimorfismo via Herencia
 * 
 * Representa un jugador de voleibol en la posición de Pasador.
 * Esta clase extiende de la clase Jugador y proporciona funcionalidad específica para los Pasadores.
 */
public class Pasador extends Jugador {
    
    /** Número de pases realizados por el pasador. */
    private int pases;

    /** Número de fintas efectivas realizadas por el pasador. */
    private int fintasEfectivas;

    /**
     * Constructor que inicializa un nuevo jugador Pasador con sus estadísticas.
     *
     * @param nombre Nombre del jugador.
     * @param pais País de origen del jugador.
     * @param errores Cantidad de errores cometidos.
     * @param aces Cantidad de aces logrados.
     * @param totalServicios Cantidad total de servicios realizados.
     * @param pases Cantidad de pases realizados por el pasador.
     * @param fintasEfectivas Cantidad de fintas efectivas realizadas por el pasador.
     */
    public Pasador(String nombre, String pais, int errores, int aces, int totalServicios, int pases, int fintasEfectivas) {
        super(nombre, pais, "Pasador", errores, aces, totalServicios);
        this.pases = pases;
        this.fintasEfectivas = fintasEfectivas;
    }

    /**
     * Calcula y devuelve la efectividad del pasador.
     * La efectividad se basa en los pases, las fintas efectivas, los errores, los aces y los servicios totales.
     *
     * @return Efectividad del jugador Pasador.
     */
    @Override
    public double calcularEfectividad() {
        return (((double)pases + fintasEfectivas - getErrores()) * 100 / (pases + fintasEfectivas + getErrores())) + (double)getAces() * 100 / getTotalServicios();
    }

    /**
     * Obtiene la cantidad de pases del pasador.
     *
     * @return Cantidad de pases.
     */
    public int getPases() {
        return pases;
    }

    /**
     * Establece la cantidad de pases del pasador.
     *
     * @param pases Nueva cantidad de pases.
     */
    public void setPases(int pases) {
        this.pases = pases;
    }

    /**
     * Obtiene la cantidad de fintas efectivas del pasador.
     *
     * @return Cantidad de fintas efectivas.
     */
    public int getFintasEfectivas() {
        return fintasEfectivas;
    }

    /**
     * Establece la cantidad de fintas efectivas del pasador.
     *
     * @param fintasEfectivas Nueva cantidad de fintas efectivas.
     */
    public void setFintasEfectivas(int fintasEfectivas) {
        this.fintasEfectivas = fintasEfectivas;
    }
}

