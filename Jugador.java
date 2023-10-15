/**
 * Alumno: Joel Antonio Jaquez Lopez
 * Fecha de creacion: 14/10/2023
 * Ultima fehca de actualizacion: 14/10/2023
 * Clase: Programacion Orientada a Objetos
 * Ejercicio: Polimorfismo via Herencia
 * 
 * Representa un jugador de voleibol con varias estadísticas.
 */
public class Jugador {

    /** Nombre del jugador. */
    protected String nombre;
    
    /** País de origen del jugador. */
    protected String pais;
    
    /** Posición en el juego del jugador. */
    protected String posicion;
    
    /** Cantidad de errores cometidos por el jugador. */
    protected int errores;
    
    /** Cantidad de aces logrados por el jugador. */
    protected int aces;
    
    /** Cantidad total de servicios realizados por el jugador. */
    protected int totalServicios;

    /**
     * Constructor que inicializa un nuevo jugador con sus estadísticas.
     *
     * @param nombre Nombre del jugador.
     * @param pais País de origen del jugador.
     * @param posicion Posición del jugador en el juego.
     * @param errores Cantidad de errores cometidos.
     * @param aces Cantidad de aces logrados.
     * @param totalServicios Cantidad total de servicios realizados.
     */
    protected Jugador(String nombre, String pais, String posicion, int errores, int aces, int totalServicios) {
        this.nombre = nombre;
        this.pais = pais;
        this.posicion = posicion;
        this.errores = errores;
        this.aces = aces;
        this.totalServicios = totalServicios;
    }

    /**
     * Calcula y devuelve la efectividad del jugador.
     * <p>En esta implementación es basica, ya que siempre devuelve 0.0. Por lo tanto subclases deben 
     * sobrescribir este método para proporcionar un cálculo específico.</p>
     *
     * @return Efectividad del jugador, por defecto es 0.0.
     */
    protected double calcularEfectividad() {
        return 0.0;
    }

    /**
     * Convierte la información del jugador a formato CSV. Esto fue agregado de ultima hora pero no es incluyo en el analisis
     *
     * @return Cadena con información del jugador en formato CSV.
     */
    protected String toCSVString() {
        return String.format("%s,%s,%s,%.2f", 
           getNombre(), 
           getPais(), 
           getPosicion(), 
           calcularEfectividad());
    }

    /**
     * Obtiene el nombre del jugador.
     *
     * @return Nombre del jugador.
     */
    protected String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del jugador.
     *
     * @param nombre Nuevo nombre del jugador.
     */
    protected void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el país del jugador.
     *
     * @return País de origen del jugador.
     */
    protected String getPais() {
        return pais;
    }

    /**
     * Establece el país del jugador.
     *
     * @param pais Nuevo país de origen.
     */
    protected void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * Obtiene la cantidad de errores del jugador.
     *
     * @return Cantidad de errores.
     */
    protected int getErrores() {
        return errores;
    }

    /**
     * Establece la cantidad de errores del jugador.
     *
     * @param errores Nueva cantidad de errores.
     */
    protected void setErrores(int errores) {
        this.errores = errores;
    }

    /**
     * Obtiene la cantidad de aces del jugador.
     *
     * @return Cantidad de aces.
     */
    protected int getAces() {
        return aces;
    }

    /**
     * Establece la cantidad de aces del jugador.
     *
     * @param aces Nueva cantidad de aces.
     */
    protected void setAces(int aces) {
        this.aces = aces;
    }

    /**
     * Obtiene la cantidad total de servicios del jugador.
     *
     * @return Cantidad total de servicios.
     */
    protected int getTotalServicios() {
        return totalServicios;
    }

    /**
     * Establece la cantidad total de servicios del jugador.
     *
     * @param totalServicios Nueva cantidad total de servicios.
     */
    protected void setTotalServicios(int totalServicios) {
        this.totalServicios = totalServicios;
    }

    /**
     * Obtiene la posición del jugador en el juego.
     *
     * @return Posición del jugador.
     */
    protected String getPosicion() {
        return posicion;
    }

    /**
     * Establece la posición del jugador en el juego.
     *
     * @param posicion Nueva posición del jugador.
     */
    protected void setPosicion(String posicion) {
        this.posicion = posicion;
    }
}

