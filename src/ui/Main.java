// Habit Tracker Project
// Author: Krissy Brown
// Date: 2025-04-24
// This class is the entry point of the JavaFX application. It loads the dashboard FXML and initializes habit data.

package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import controller.DataManager;
import model.HabitCollection;

public class Main extends Application {

    public static HabitCollection habitCollection;

    /**
     * Starts the JavaFX app and loads the dashboard UI. Habits are loaded from file.
     * @param primaryStage the main app window
     * @throws Exception if FXML fails to load
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        habitCollection = DataManager.load();

        Parent root = FXMLLoader.load(getClass().getResource("/ui/dashboard.fxml"));
        primaryStage.setTitle("Habit Tracker Dashboard");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    /**
     * Saves the habit collection when the application closes.
     * @throws Exception if saving fails
     */
    @Override
    public void stop() throws Exception {
        DataManager.save(habitCollection);
    }

    /**
     * Launches the application.
     * @param args command-line args
     */
    public static void main(String[] args) {
        launch(args);
    }
}
