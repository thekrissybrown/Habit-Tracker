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
import javafx.stage.Stage;
import model.Habit;

public class HabitTrackerUI {

    @FXML
    private ListView<String> habitListView;

    @FXML
    private Button addHabitButton;

    private ObservableList<String> habitNames = FXCollections.observableArrayList();

    /**
     * Initializes the UI with data from the HabitCollection.
     * Populates the ListView with habit names.
     */
    @FXML
    public void initialize() {
        for (Habit habit : Main.habitCollection.getAllHabits()) {
            habitNames.add(habit.getName());
        }
        habitListView.setItems(habitNames);
    }

    /**
     * Opens a new window to add a habit using addHabit.fxml.
     *
     * @throws Exception if the FXML file cannot be loaded
     */
    @FXML
    private void handleAddHabitButton() throws Exception {
        Parent addHabitView = FXMLLoader.load(
                getClass().getResource("/addHabit.fxml")
        );
        Stage stage = new Stage();
        stage.setTitle("Add New Habit");
        stage.setScene(new Scene(addHabitView));
        stage.show();
    }
}
