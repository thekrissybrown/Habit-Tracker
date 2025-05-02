// Habit Tracker Project
// Author: Krissy Brown
// Date: 2025-04-24
// This class is the entry point of the JavaFX application. It loads the dashboard FXML and initializes habit data.

package ui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import controller.FileDataManager;
import controller.HabitCollection;
import java.io.IOException;
import java.net.URL;

public class Main extends Application {

    // Global access to the habit collection
    public static HabitCollection habitCollection;

    // ───────────────────────────────────────────────────────────────
    // 🟢 JavaFX Lifecycle: Entry Point
    // ───────────────────────────────────────────────────────────────

    /**
     * JavaFX main method.
     * @param args command line args
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Initializes the habit collection and loads the dashboard view.
     * @param primaryStage the primary stage of the JavaFX application
     */
    @Override
    public void start(Stage primaryStage) {
        try {
            habitCollection = FileDataManager.load();
            loadDashboard(primaryStage);
        } catch (IOException e) {
            showError("Failed to load dashboard UI.", e);
        } catch (Exception e) {
            showError("Failed to load habit data.", e);
        }
    }

    /**
     * Saves habit collection when app is closed.
     * @throws Exception if save fails
     */
    @Override
    public void stop() throws Exception {
        FileDataManager.save(habitCollection);
    }

    // ───────────────────────────────────────────────────────────────
    // 📋 Dashboard Loader
    // ───────────────────────────────────────────────────────────────

    /**
     * Loads the dashboard.fxml layout and shows the main window.
     * @param primaryStage the main stage
     * @throws IOException if FXML cannot be loaded
     */
    private void loadDashboard(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ui/dashboard.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);

        // Modern CSS styling with a null-safe load
        URL cssUrl = getClass().getResource("/ui/style.css");
        if (cssUrl != null) {
            scene.getStylesheets().add(cssUrl.toExternalForm());
        } else {
            System.out.println("Warning: CSS file not found.");
        }

        primaryStage.setTitle("Habit Tracker Dashboard");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // ───────────────────────────────────────────────────────────────
    // ❌ Error Handling
    // ───────────────────────────────────────────────────────────────

    /**
     * Shows a fatal startup error alert.
     * @param message the header message
     * @param e the exception details
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
