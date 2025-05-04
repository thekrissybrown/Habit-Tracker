// Habit Tracker Project
// Author: Krissy Brown
// Date: 2025-04-24
// Controller for the add habit form. Handles creation of a new habit and UI closure.

package ui;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Habit;

/**
 * Controller for the Add Habit form.
 * Handles user input and adds a new habit to the main collection.
 *
 * Author: Krissy Brown
 * Date: 2025-04-24
 */
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
     * Handles user clicking "Save Habit".
     * Creates a new Habit instance and closes the form if valid.
     */
    @FXML
    private void handleSaveHabit() {
        String name = habitNameField.getText().trim();

        if (!name.isEmpty()) {
            Habit newHabit = new Habit(name, "", null); // Placeholder for description/category
            Main.habitCollection.addHabit(newHabit);
            newHabit.setEmoji("📖"); // ✅ Set default emoji for now

            // Close the window
            Stage stage = (Stage) habitNameField.getScene().getWindow();
            stage.close();
        } else {
            // Show alert for invalid input
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Missing Name");
            alert.setHeaderText("Habit name cannot be empty.");
            alert.setContentText("Please enter a name for the habit.");
            alert.showAndWait();
        }
    }
    /**
     * Handles user clicking "Cancel".
     * Closes the form without saving.
     */
    @FXML
    private void handleCancel() {
        Stage stage = (Stage) habitNameField.getScene().getWindow();
        stage.close();
    }
}
