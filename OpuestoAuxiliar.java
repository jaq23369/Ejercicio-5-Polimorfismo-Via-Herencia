/**
 * Alumno: Joel Antonio Jaquez Lopez
 * Fecha de creacion: 14/10/2023
 * Ultima fehca de actualizacion: 14/10/2023
 * Clase: Programacion Orientada a Objetos
 * Ejercicio 5: Polimorfismo via Herencia
 * 
 * Representa un jugador de voleibol en la posición de Opuesto o Auxiliar.
 * Esta clase extiende de la clase Jugador y proporciona funcionalidad específica para los jugadores Opuesto o Auxiliar.
 */
public class OpuestoAuxiliar extends Jugador {
    
    /** Número de ataques realizados por el jugador. */
    private int ataques;

    /** Número de bloqueos efectivos realizados por el jugador. */
    private int bloqueosEfectivos;

    /** Número de bloqueos que falló el jugador. */
    private int bloqueosFallidos;

    /**
     * Constructor que inicializa un nuevo jugador Opuesto o Auxiliar con sus estadísticas.
     *
     * @param nombre Nombre del jugador.
     * @param pais País de origen del jugador.
     * @param errores Cantidad de errores cometidos.
     * @param aces Cantidad de aces logrados.
     * @param totalServicios Cantidad total de servicios realizados.
     * @param ataques Cantidad de ataques realizados.
     * @param bloqueosEfectivos Cantidad de bloqueos efectivos realizados.
     * @param bloqueosFallidos Cantidad de bloqueos que falló el jugador.
     */
    public OpuestoAuxiliar(String nombre, String pais, int errores, int aces, int totalServicios, int ataques, int bloqueosEfectivos, int bloqueosFallidos) {
        super(nombre, pais, "OpuestoAuxiliar", errores, aces, totalServicios);
        this.ataques = ataques;
        this.bloqueosEfectivos = bloqueosEfectivos;
        this.bloqueosFallidos = bloqueosFallidos;
    }

    /**
     * Calcula y devuelve la efectividad del jugador Opuesto o Auxiliar.
     * La efectividad se basa en los ataques, bloqueos efectivos, bloqueos fallidos, errores, aces y servicios totales.
     *
     * @return Efectividad del jugador.
     */
    @Override
    public double calcularEfectividad() {
        return (((double)ataques + bloqueosEfectivos - bloqueosFallidos - getErrores()) * 100 / (ataques + bloqueosEfectivos + bloqueosFallidos + getErrores())) + (double)getAces() * 100 / getTotalServicios();
    }

    /**
     * Obtiene la cantidad de ataques del jugador.
     *
     * @return Cantidad de ataques.
     */
    public int getAtaques() {
        return ataques;
    }

    /**
     * Establece la cantidad de ataques del jugador.
     *
     * @param ataques Nueva cantidad de ataques.
     */
    public void setAtaques(int ataques) {
        this.ataques = ataques;
    }

    /**
     * Obtiene la cantidad de bloqueos efectivos del jugador.
     *
     * @return Cantidad de bloqueos efectivos.
     */
    public int getBloqueosEfectivos() {
        return bloqueosEfectivos;
    }

    /**
     * Establece la cantidad de bloqueos efectivos del jugador.
     *
     * @param bloqueosEfectivos Nueva cantidad de bloqueos efectivos.
     */
    public void setBloqueosEfectivos(int bloqueosEfectivos) {
        this.bloqueosEfectivos = bloqueosEfectivos;
    }

    /**
     * Obtiene la cantidad de bloqueos fallidos del jugador.
     *
     * @return Cantidad de bloqueos fallidos.
     */
    public int getBloqueosFallidos() {
        return bloqueosFallidos;
    }

    /**
     * Establece la cantidad de bloqueos fallidos del jugador.
     *
     * @param bloqueosFallidos Nueva cantidad de bloqueos fallidos.
     */
    public void setBloqueosFallidos(int bloqueosFallidos) {
        this.bloqueosFallidos = bloqueosFallidos;
    }
}
