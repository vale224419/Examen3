package co.edu.poli.examen3.modelo;

import java.io.*;
import java.util.*;

/**
 * Clase abstracta que representa una actividad académica.
 */
public abstract class ActividadAcademica implements Serializable {

    /**
     * Constructor que inicializa una actividad académica.
     * 
     * @param codigo El código de la actividad.
     * @param nombre El nombre de la actividad.
     * @param fechaRealizacion La fecha en que se realiza la actividad.
     * @param duracionHoras La duración de la actividad en horas.
     */
    public ActividadAcademica(int codigo, String nombre, String fechaRealizacion, int duracionHoras) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.fechaRealizacion = fechaRealizacion;
        this.duracionHoras = duracionHoras;
    }

    private int codigo;
    private String nombre;
    private String fechaRealizacion;
    private int duracionHoras;

    /**
     * Obtiene el código de la actividad.
     * 
     * @return El código de la actividad.
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Establece el código de la actividad.
     * 
     * @param codigo El código de la actividad.
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Obtiene el nombre de la actividad.
     * 
     * @return El nombre de la actividad.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la actividad.
     * 
     * @param nombre El nombre de la actividad.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la fecha de realización de la actividad.
     * 
     * @return La fecha de realización de la actividad.
     */
    public String getFechaRealizacion() {
        return fechaRealizacion;
    }

    /**
     * Establece la fecha de realización de la actividad.
     * 
     * @param fechaRealizacion La fecha de realización de la actividad.
     */
    public void setFechaRealizacion(String fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    /**
     * Obtiene la duración de la actividad en horas.
     * 
     * @return La duración en horas de la actividad.
     */
    public int getDuracionHoras() {
        return duracionHoras;
    }

    /**
     * Establece la duración de la actividad en horas.
     * 
     * @param duracionHoras La duración en horas de la actividad.
     */
    public void setDuracionHoras(int duracionHoras) {
        this.duracionHoras = duracionHoras;
    }
}
