package co.edu.poli.examen3.modelo;

import java.io.Serializable;
/**
 * Representa un recurso externo utilizado en una actividad académica.
 */
public class RecursoExterno implements Serializable {

    private int id;
    private String nombreRecurso;
    private String proveedor;

    /**
     * Constructor para inicializar un recurso externo.
     * 
     * @param id El identificador del recurso.
     * @param nombreRecurso El nombre del recurso.
     * @param proveedor El proveedor del recurso.
     */
    public RecursoExterno(int id, String nombreRecurso, String proveedor) {
        this.id = id;
        this.nombreRecurso = nombreRecurso;
        this.proveedor = proveedor;
    }

    /**
     * Representación en formato de cadena del recurso externo.
     * 
     * @return La representación del recurso en forma de cadena.
     */
    @Override
    public String toString() {
        return nombreRecurso + " (Proveedor: " + proveedor + ")";
    }
}
