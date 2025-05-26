package co.edu.poli.examen3.modelo;

/**
 * Clase que representa una actividad académica de tipo taller.
 */
public class Taller extends ActividadAcademica {

    private String nivelPractico;
    private RecursoExterno recurso;

    /**
     * Constructor para inicializar un taller.
     * 
     * @param codigo El código de la actividad.
     * @param nombre El nombre de la actividad.
     * @param fechaRealizacion La fecha de realización de la actividad.
     * @param duracionHoras La duración en horas de la actividad.
     * @param nivelPractico El nivel práctico del taller.
     * @param recurso El recurso externo utilizado en el taller.
     */
    public Taller(int codigo, String nombre, String fechaRealizacion, int duracionHoras,
                  String nivelPractico, RecursoExterno recurso) {
        super(codigo, nombre, fechaRealizacion, duracionHoras);
        this.nivelPractico = nivelPractico;
        this.recurso = recurso;
    }

    /**
     * Representación en formato de cadena del taller.
     * 
     * @return La representación del taller en forma de cadena.
     */
    @Override
    public String toString() {
        return "Taller [codigo=" + getCodigo() + ", nombre=" + getNombre() + ", fecha=" + getFechaRealizacion() +
                ", duracion=" + getDuracionHoras() + ", nivel=" + nivelPractico + ", recurso=" + recurso + "]";
    }
}
