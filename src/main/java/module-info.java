module co.edu.poli.examen3 {
    requires javafx.controls;
    requires javafx.fxml;

    opens co.edu.poli.examen3.vista to javafx.fxml;
    opens co.edu.poli.examen3.controlador to javafx.fxml;
    exports co.edu.poli.examen3.vista;
    exports co.edu.poli.examen3.controlador;
}
