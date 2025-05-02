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

    // ───────────────────────────────────────────────────────────────
    // 💬 FXML Fields
    // ───────────────────────────────────────────────────────────────

    @FXML
    private TextField habitNameField;

    // ───────────────────────────────────────────────────────────────
    // 💾 Event Handlers
    // ───────────────────────────────────────────────────────────────

    /**
     * Handles saving a new habit entered by the user.
     * Adds it directly to the main habit collection.
     */
    @FXML
    private void handleSaveHabit() {
        String name = habitNameField.getText().trim();

        if (!name.isEmpty()) {
            Habit newHabit = new Habit(name, "", null); // description/category left empty for now
            Main.habitCollection.addHabit(newHabit);

            Stage stage = (Stage) habitNameField.getScene().getWindow();
            stage.close();
        } else {
            System.out.println("Habit name cannot be empty.");
            // Optional: You could show an alert here instead of just printing
        }
    }
}
