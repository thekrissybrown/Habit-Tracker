// Habit Tracker Project
// Author: Krissy Brown
// Date: 2025-04-24
// This class is the entry point of the JavaFX application. It loads the dashboard FXML and initializes habit data.

package ui;

import controller.FileDataManager;
import controller.HabitCollection;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Entry point for the Habit Tracker JavaFX application.
 * Loads the dashboard UI and initializes persistent habit data.
 *
 * Author: Krissy Brown
 * Date: 2025-04-24
 */
public class Main extends Application {

    // Globally accessible collection of habits
    public static HabitCollection habitCollection;

    /**
     * Java main method.
     * Launches the JavaFX application.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Initializes the app by loading saved habits and launching the dashboard.
     *
     * @param primaryStage the main application window
     */
    @Override
    public void start(Stage primaryStage) {
        // Debug: Check if the serialized data file exists
        Path filePath = Paths.get("data", "habits.ser");
        System.out.println("[Debug] habits.ser exists? " + Files.exists(filePath));

        try {
            habitCollection = FileDataManager.load();
            loadDashboard(primaryStage);
        } catch (IOException e) {
            showError("Failed to load dashboard UI.", e);
        } catch (Exception e) {
            showError("Unexpected error occurred.", e);
        }
    }

    /**
     * Saves habits to disk when the app is closed.
     */
    @Override
    public void stop() throws Exception {
        FileDataManager.save(habitCollection);
    }

    /**
     * Loads the main dashboard from FXML and displays it in the primary stage.
     *
     * @param primaryStage the primary application window
     * @throws IOException if FXML loading fails
     */
    private void loadDashboard(Stage primaryStage) throws IOException {
        URL fxmlUrl = getClass().getResource("/ui/dashboard.fxml");
        if (fxmlUrl == null) throw new IOException("Missing FXML: /ui/dashboard.fxml");

        Parent root = new FXMLLoader(fxmlUrl).load();
        Scene scene = new Scene(root);

        // Load and apply external CSS (optional)
        URL cssUrl = getClass().getResource("/ui/style.css");
        if (cssUrl != null) {
            scene.getStylesheets().add(cssUrl.toExternalForm());
        } else {
            System.out.println("⚠️ Warning: style.css not found.");
        }

        primaryStage.setTitle("Habit Tracker Dashboard");
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    /**
     * Displays a fatal error alert and exits the app.
     *
     * @param message message to display
     * @param e       exception details
     */
    private void showError(String message, Exception e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Startup Error");
        alert.setHeaderText(message);
        alert.setContentText(e.getMessage());
        alert.showAndWait();
        Platform.exit();
    }
}
