package co.edu.poli.examen3.modelo;

/**
 * Representa una clase como una actividad académica.
 * Hereda de {@link ActividadAcademica}.
 */
public class Clase extends ActividadAcademica {

    /** Número de sesión de la clase. */
    private int numeroSesion;

    /**
     * Constructor para crear una clase.
     *
     * @param codigo           Código único de la actividad.
     * @param nombre           Nombre de la actividad.
     * @param fechaRealizacion Fecha de realización de la actividad (formato YYYY-MM-DD).
     * @param duracionHoras    Duración de la clase en horas.
     * @param numeroSesion     Número de sesión de la clase.
     */
    public Clase(int codigo, String nombre, String fechaRealizacion, int duracionHoras, int numeroSesion) {
        super(codigo, nombre, fechaRealizacion, duracionHoras);
        this.numeroSesion = numeroSesion;
    }

    /**
     * Devuelve una representación en cadena de la clase.
     *
     * @return Cadena con los detalles de la clase.
     */
    @Override
    public String toString() {
        return "Clase [codigo=" + getCodigo() + ", nombre=" + getNombre() + ", fecha=" + getFechaRealizacion() +
                ", duracion=" + getDuracionHoras() + ", numeroSesion=" + numeroSesion + "]";
    }
}
