package co.edu.poli.examen3.vista;

// Importaciones necesarias para JavaFX
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Clase principal de la aplicación JavaFX
 */
public class App extends Application {

    // Escena principal de la aplicación
    private static Scene scene;

    // Método que se ejecuta al iniciar la aplicación
    @Override
    public void start(Stage stage) throws IOException {
        // Carga el archivo FXML y configura la escena principal
        scene = new Scene(loadFXML("FXML3"), 300, 450);
        stage.setScene(scene);
        stage.show(); // Muestra la ventana
    }

    // Método para cambiar la raíz de la escena
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    // Método para cargar un archivo FXML dado su nombre (sin extensión)
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    // Método main que lanza la aplicación
    public static void main(String[] args) {
        launch();
    }
}
