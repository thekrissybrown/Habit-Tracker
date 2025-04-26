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
import controller.HabitCollection;
import java.io.IOException;
import controller.DataLoadException;
import javafx.scene.control.Alert;
import javafx.application.Platform;

public class Main extends Application {
    private final HabitCollectionManager habitManager;
    
    public Main() {
        this.habitManager = HabitCollectionManager.getInstance();
    }
    
    @Override
    public void start(Stage primaryStage) {
        try {
            initializeHabitCollection();
            loadAndShowMainScene(primaryStage);
        } catch (IOException e) {
            handleStartupError("Failed to load UI", e);
        } catch (DataLoadException e) {
            handleStartupError("Failed to load habits", e);
        }
    }
    
    private void initializeHabitCollection() throws DataLoadException {
        try {
            habitManager.initialize(DataManager.load());
        } catch (Exception e) {
            throw new DataLoadException("Failed to load habit data", e);
        }
    }
    
    private void loadAndShowMainScene(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ui/dashboard.fxml"));
        Parent root = loader.load();
        
        // Inject the habitManager into the controller
        HabitTrackerUI controller = loader.getController();
        controller.setHabitManager(habitManager);
        
        primaryStage.setTitle("Habit Tracker Dashboard");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    
    private void handleStartupError(String message, Exception e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Startup Error");
        alert.setHeaderText(message);
        alert.setContentText(e.getMessage());
        alert.showAndWait();
        Platform.exit();
    }
    
    // Singleton manager class for HabitCollection
    public static class HabitCollectionManager {
        private static final HabitCollectionManager INSTANCE = new HabitCollectionManager();
        private HabitCollection habitCollection;
        
        private HabitCollectionManager() {
            this.habitCollection = new HabitCollection();
        }
        
        public static HabitCollectionManager getInstance() {
            return INSTANCE;
        }
        
        public void initialize(HabitCollection loadedCollection) {
            this.habitCollection = loadedCollection != null ? loadedCollection : new HabitCollection();
        }
        
        public HabitCollection getHabitCollection() {
            return habitCollection;
        }
    }
}