/** 
 * Alumno: Joel Antonio Jaquez Lopez
 * Fecha de creacion: 14/10/2023
 * Ultima fehca de actualizacion: 14/10/2023
 * Clase: Programacion Orientada a Objetos
 * Ejercicio 5: Polimorfismo via Herencia
 * 
 * Representa un jugador de voleibol en la posición de Líbero.
 * Esta clase extiende de la clase Jugador y proporciona funcionalidad específica para los Líberos.
 */
public class Libero extends Jugador {
    
    /** Número de recibos efectivos realizados por el líbero. */
    private int recibosEfectivos;

    /**
     * Constructor que inicializa un nuevo jugador Líbero con sus estadísticas.
     *
     * @param nombre Nombre del jugador.
     * @param pais País de origen del jugador.
     * @param errores Cantidad de errores cometidos.
     * @param aces Cantidad de aces logrados.
     * @param totalServicios Cantidad total de servicios realizados.
     * @param recibosEfectivos Cantidad de recibos efectivos logrados por el líbero.
     */
    public Libero(String nombre, String pais, int errores, int aces, int totalServicios, int recibosEfectivos) {
        super(nombre, pais, "Libero", errores, aces, totalServicios);
        this.recibosEfectivos = recibosEfectivos;
    }

    /**
     * Calcula y devuelve la efectividad del líbero.
     * La efectividad se basa en los recibos efectivos, los errores, los aces y los servicios totales.
     *
     * @return Efectividad del jugador Líbero.
     */
    @Override
    public double calcularEfectividad() {
        return (((double)recibosEfectivos - getErrores()) * 100 / (recibosEfectivos + getErrores())) + (double)getAces() * 100 / getTotalServicios();
    }

    /**
     * Obtiene la cantidad de recibos efectivos del líbero.
     *
     * @return Cantidad de recibos efectivos.
     */
    public int getRecibosEfectivos() {
        return recibosEfectivos;
    }

    /**
     * Establece la cantidad de recibos efectivos del líbero.
     *
     * @param recibosEfectivos Nueva cantidad de recibos efectivos.
     */
    public void setRecibosEfectivos(int recibosEfectivos) {
        this.recibosEfectivos = recibosEfectivos;
    }
}
