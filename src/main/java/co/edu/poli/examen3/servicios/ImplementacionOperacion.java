package co.edu.poli.examen3.servicios;

import co.edu.poli.examen3.modelo.ActividadAcademica;
import java.io.*;

/**
 * Implementación de la interfaz Operacion para realizar operaciones sobre
 * actividades académicas.
 */
public class ImplementacionOperacion implements Operacion, OperacionSerializacion{

    private ActividadAcademica[] actividades = new ActividadAcademica[10];

    /**
     * Crea una nueva actividad académica.
     *
     * @param act La actividad a crear.
     * @return Un mensaje de éxito o error.
     */
    @Override
    public String create(ActividadAcademica act) {
        for (int i = 0; i < actividades.length; i++) {
            if (actividades[i] == null) {
                actividades[i] = act;
                return "Actividad agregada";
            }
        }
        return "No hay espacio";
    }

    /**
     * Lee una actividad académica por su código.
     *
     * @param codigo El código de la actividad.
     * @return La actividad encontrada o null si no existe.
     */
    @Override
    public ActividadAcademica read(int codigo) {
        for (ActividadAcademica act : actividades) {
            if (act != null && act.getCodigo() == codigo) {
                return act;
            }
        }
        return null;
    }

    /**
     * Lee todas las actividades académicas.
     *
     * @return Un arreglo con todas las actividades.
     */
    @Override
    public ActividadAcademica[] readAll() {
        return actividades;
    }

    /**
     * Actualiza una actividad académica existente.
     *
     * @param codigo El código de la actividad a actualizar.
     * @param nueva La nueva actividad.
     * @return La actividad actualizada o null si no se encontró.
     */
    @Override
    public ActividadAcademica update(int codigo, ActividadAcademica nueva) {
        for (int i = 0; i < actividades.length; i++) {
            if (actividades[i] != null && actividades[i].getCodigo() == codigo) {
                actividades[i] = nueva;
                return nueva;
            }
        }
        return null;
    }

    /**
     * Elimina una actividad académica por su código.
     *
     * @param codigo El código de la actividad a eliminar.
     * @return Un mensaje de éxito o error.
     */
    @Override
    public String delete(int codigo) {
        for (int i = 0; i < actividades.length; i++) {
            if (actividades[i] != null && actividades[i].getCodigo() == codigo) {
                actividades[i] = null;
                return "Eliminado";
            }
        }
        return "No encontrado";
    }

    /**
     * Serializa un arreglo de actividades académicas en un archivo.
     *
     * @param arreglo El arreglo de actividades.
     * @param path La ruta del archivo.
     * @param name El nombre del archivo.
     * @return Un mensaje de éxito o error.
     */
    @Override
    public String serializar(ActividadAcademica[] arreglo, String path, String name) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path + "/" + name))) {
            oos.writeObject(arreglo);
            return "Serializado";
        } catch (IOException e) {
            return "Error al serializar";
        }
    }

    /**
     * Deserializa un archivo de actividades académicas.
     *
     * @param path La ruta del archivo.
     * @param name El nombre del archivo.
     * @return Un arreglo de actividades deserializadas o null si ocurre un
     * error.
     */
    @Override

    public ActividadAcademica[] deserializar(String path, String name) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path + "/" + name))) {
            ActividadAcademica[] recuperadas = (ActividadAcademica[]) ois.readObject();
            this.actividades = recuperadas;
            return recuperadas;
        } catch (Exception e) {
            e.printStackTrace();
            return new ActividadAcademica[0];
        }
    }

}
