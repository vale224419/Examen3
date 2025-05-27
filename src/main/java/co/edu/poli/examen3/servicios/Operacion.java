package co.edu.poli.examen3.servicios;

import co.edu.poli.examen3.modelo.ActividadAcademica;

/**
 * Esta interfaz define las operaciones CRUD básicas y de serialización
 * que se pueden realizar sobre objetos de tipo ActividadAcademica.
 */
public interface Operacion {

    /**
     * Crea una nueva actividad académica.
     *
     * @param act la actividad a agregar
     * @return mensaje indicando el resultado de la operación
     */
    String create(ActividadAcademica act);

    /**
     * Busca una actividad por su código.
     *
     * @param codigo el código de la actividad
     * @return la actividad correspondiente o null si no se encuentra
     */
    ActividadAcademica read(int codigo);

    /**
     * Retorna todas las actividades almacenadas.
     *
     * @return arreglo de actividades académicas
     */
    ActividadAcademica[] readAll();

    /**
     * Actualiza una actividad existente con nuevos datos.
     *
     * @param codigo el código de la actividad a actualizar
     * @param act la nueva actividad con los datos actualizados
     * @return la actividad actualizada o null si no se encuentra
     */
    ActividadAcademica update(int codigo, ActividadAcademica act);

    /**
     * Elimina una actividad académica por su código.
     *
     * @param codigo el código de la actividad a eliminar
     * @return mensaje indicando el resultado de la operación
     */
    String delete(int codigo);
}
