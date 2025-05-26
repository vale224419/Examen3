package co.edu.poli.examen3.controlador;

// Importación de clases necesarias del modelo y servicios del proyecto
import co.edu.poli.examen3.modelo.*;
import co.edu.poli.examen3.servicios.ImplementacionOperacion;

// Importación de clases de JavaFX para la interfaz gráfica
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory;

import java.time.LocalDate;

// Clase que controla el formulario principal de la interfaz gráfica
public class formulario {

    // Servicio para manejar las operaciones con las actividades académicas
    private ImplementacionOperacion servicio;

    // Elementos de la interfaz conectados mediante @FXML
    @FXML private MenuItem actualizar;
    @FXML private MenuItem borrar;
    @FXML private ComboBox<String> boxtipo;
    @FXML private Button bttabrir;
    @FXML private Button bttguardar;
    @FXML private MenuItem crrear;
    @FXML private DatePicker fecha;
    @FXML private MenuItem leerporid;
    @FXML private MenuItem leertodos;
    @FXML private TextArea mostrar;
    @FXML private Spinner<Integer> spinnerhoras;
    @FXML private TextField txtid;
    @FXML private TextField txtnombre;

    // Método que se ejecuta al iniciar el formulario
    @FXML
    public void initialize() {
        servicio = new ImplementacionOperacion(); // Inicializa el servicio

        // Configura opciones del ComboBox y valores por defecto
        boxtipo.getItems().addAll("Clase", "Taller");
        spinnerhoras.setValueFactory(new IntegerSpinnerValueFactory(1, 100, 2));
        fecha.setValue(LocalDate.now());

        // Limpia campos
        mostrar.clear();
        txtid.clear();
        txtnombre.clear();

        // Asocia eventos de menú con los métodos correspondientes
        leerporid.setOnAction(this::Read);
        leertodos.setOnAction(this::ReadAll);
        actualizar.setOnAction(this::Update);
        borrar.setOnAction(this::Delete);
        crrear.setOnAction(this::Create);
    }

    // Método para crear una nueva actividad académica
    @FXML
    void Create(ActionEvent event) {
        try {
            int id = Integer.parseInt(txtid.getText());
            String nombre = txtnombre.getText();
            LocalDate fechaSel = fecha.getValue();
            int horas = spinnerhoras.getValue();
            String tipo = boxtipo.getValue();

            // Validación de campos
            if (tipo == null || nombre.isEmpty()) {
                mostrar.setText("Completa todos los campos antes de crear.");
                return;
            }

            // Crea el objeto según el tipo seleccionado
            ActividadAcademica nueva = switch (tipo) {
                case "Clase" -> new Clase(id, nombre, fechaSel.toString(), horas, 1);
                case "Taller" -> new Taller(id, nombre, fechaSel.toString(), horas, "Avanzado",
                        new RecursoExterno(1, "Proyector", "HP"));
                default -> null;
            };

            if (nueva == null) {
                mostrar.setText(" Tipo inválido.");
                return;
            }

            // Envía la actividad al servicio para ser registrada
            String res = servicio.create(nueva);
            mostrar.setText(res);
        } catch (NumberFormatException e) {
            mostrar.setText("Error: Código debe ser un número.");
        }
    }

    // Método para buscar una actividad por ID
    @FXML
    void Read(ActionEvent event) {
        try {
            int codigo = Integer.parseInt(txtid.getText());
            ActividadAcademica actividad = servicio.read(codigo);

            if (actividad != null) {
                // Muestra la información de la actividad en los campos
                txtnombre.setText(actividad.getNombre());
                fecha.setValue(LocalDate.parse(actividad.getFechaRealizacion()));
                spinnerhoras.getValueFactory().setValue(actividad.getDuracionHoras());
                boxtipo.setValue(actividad instanceof Clase ? "Clase" : "Taller");
                mostrar.setText("Actividad encontrada:\n" + actividad);
            } else {
                // Limpia los campos si no se encuentra
                mostrar.setText("No se encontró ninguna actividad con ese código.");
                txtnombre.clear();
                fecha.setValue(LocalDate.now());
                spinnerhoras.getValueFactory().setValue(1);
                boxtipo.setValue(null);
            }
        } catch (NumberFormatException e) {
            mostrar.setText("Código inválido.");
        } catch (Exception e) {
            mostrar.setText("Error al buscar: " + e.getMessage());
        }
    }

    // Método para listar todas las actividades registradas
    @FXML
    void ReadAll(ActionEvent event) {
        StringBuilder sb = new StringBuilder();
        for (ActividadAcademica a : servicio.readAll()) {
            if (a != null) {
                sb.append(a).append("\n");
            }
        }
        mostrar.setText(sb.length() > 0 ? sb.toString() : "No hay actividades registradas.");
    }

    // Método para actualizar una actividad existente
    @FXML
    void Update(ActionEvent event) {
        try {
            int id = Integer.parseInt(txtid.getText());
            String nombre = txtnombre.getText();
            LocalDate fechaSel = fecha.getValue();
            int horas = spinnerhoras.getValue();
            String tipo = boxtipo.getValue();

            if (nombre.isEmpty() || tipo == null) {
                mostrar.setText("⚠️ Completa todos los campos.");
                return;
            }

            // Crea nueva instancia con los datos actualizados
            ActividadAcademica nueva = switch (tipo) {
                case "Clase" -> new Clase(id, nombre, fechaSel.toString(), horas, 1);
                case "Taller" -> new Taller(id, nombre, fechaSel.toString(), horas, "Intermedio",
                        new RecursoExterno(2, "Tablero Digital", "SmartTech"));
                default -> null;
            };

            // Llama al servicio para actualizar
            ActividadAcademica actualizada = servicio.update(id, nueva);
            mostrar.setText(actualizada != null
                    ? "Actividad actualizada:\n" + actualizada
                    : "No se encontró la actividad para actualizar.");
        } catch (NumberFormatException e) {
            mostrar.setText("Código inválido.");
        }
    }

    // Método para eliminar una actividad por ID
    @FXML
    void Delete(ActionEvent event) {
        try {
            int id = Integer.parseInt(txtid.getText());
            String res = servicio.delete(id);
            mostrar.setText(res);
        } catch (NumberFormatException e) {
            mostrar.setText("Código inválido.");
        }
    }

    // Método para serializar las actividades guardadas
    @FXML
    void Serializar(ActionEvent event) {
        String resultado = servicio.serializar(servicio.readAll(), "./", "datos_academicos.dat");
        mostrar.setText(resultado);
    }

    // Método para deserializar y mostrar los datos guardados
    @FXML
    void deserializar(ActionEvent event) {
        ActividadAcademica[] des = servicio.deserializar("./", "datos_academicos.dat");
        if (des != null && des.length > 0) {
            mostrar.setText("Datos deserializados:\n");
            StringBuilder sb = new StringBuilder();
            for (ActividadAcademica a : des) {
                if (a != null) {
                    sb.append(a).append("\n");
                }
            }
            mostrar.appendText(sb.toString());
        } else {
            mostrar.setText("No se encontraron datos para deserializar.");
        }
    }
}
