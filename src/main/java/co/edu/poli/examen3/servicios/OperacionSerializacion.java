package co.edu.poli.examen3.servicios;

import co.edu.poli.examen3.modelo.ActividadAcademica;

public interface OperacionSerializacion {

    /**
     * Serializa un arreglo de actividades a un archivo.
     *
     * @param arreglo arreglo de actividades a serializar
     * @param path ruta donde se almacenará el archivo
     * @param name nombre del archivo
     * @return mensaje indicando el resultado de la operación
     */
    String serializar(ActividadAcademica[] arreglo, String path, String name);

    /**
     * Deserializa un archivo para recuperar el arreglo de actividades.
     *
     * @param path ruta donde se encuentra el archivo
     * @param name nombre del archivo
     * @return arreglo de actividades deserializadas o null si hay error
     */
    ActividadAcademica[] deserializar(String path, String name);
}
