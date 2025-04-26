// Habit Tracker Project
// Author: Krissy Brown
// Date: 2025-04-24
// Controller for the add habit form. Handles creation of a new habit and UI closure.

package ui;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Habit;

public class AddHabitController {

    @FXML
    private TextField habitNameField;

    private Main.HabitCollectionManager habitManager;

    public void setHabitManager(Main.HabitCollectionManager manager) {
        this.habitManager = manager;
    }

    @FXML
    private void handleSaveHabit() {
        String name = habitNameField.getText().trim();

        if (!name.isEmpty()) {
            Habit newHabit = new Habit(name, "", null);
            habitManager.getHabitCollection().addHabit(newHabit);

            Stage stage = (Stage) habitNameField.getScene().getWindow();
            stage.close();
        } else {
            System.out.println("Habit name cannot be empty.");
        }
    }
}
