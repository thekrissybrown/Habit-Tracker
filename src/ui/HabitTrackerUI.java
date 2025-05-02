// Habit Tracker Project
// Author: Krissy Brown
// Date: 2025-04-24
// Controller for the dashboard scene. Manages the display of tracked habits and transitions to the add habit form.

package ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import model.Habit;

public class HabitTrackerUI {

    @FXML
    private ListView<String> habitListView;
    private final ObservableList<String> habitNames = FXCollections.observableArrayList();

    /**
     * Initializes the dashboard UI by loading all habit names into the list view.
     */
    @FXML
    public void initialize() {
        habitNames.clear();
        for (Habit habit : Main.habitCollection.getAllHabits()) {
            habitNames.add(habit.getName());
        }
        habitListView.setItems(habitNames);
    }

    /**
     * Opens the "Add Habit" form in a new window.
     * Shows an alert if the FXML file fails to load.
     */
    @FXML
    private void handleAddHabitButton() {
        try {
            Parent addHabitView = FXMLLoader.load(getClass().getResource("/addHabit.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Add New Habit");
            stage.setScene(new Scene(addHabitView));
            stage.show();
        } catch (Exception e) {
            showError("Failed to open Add Habit form.", e);
        }
    }

    /**
     * Displays an error alert dialog with the given message and exception details.
     *
     * @param message the error message to show
     * @param e the exception that occurred
     */
    private void showError(String message, Exception e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("UI Error");
        alert.setHeaderText(message);
        alert.setContentText(e.getMessage());
        alert.showAndWait();
    }
}
