// Habit Tracker Project
// Author: Krissy Brown
// Date: 2025-04-24
// Controller for the add habit form. Handles creation of a new habit and UI closure.

package ui;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
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

    @FXML
    private TextField emojiField; // 🆕 field for emoji entry
    // 🆕 field for emoji entry
    @FXML
    private ComboBox <String> emojiPicker;


    @FXML
    private Label validationLabel;


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
        String emoji = emojiField.getText().trim();

        if (!name.isEmpty()) {
            Habit newHabit = new Habit(name, "", null); // Placeholder for description/category
            String selectedEmoji = emojiPicker.getValue();
            newHabit.setEmoji(selectedEmoji != null ? selectedEmoji : "🌱");

            Main.habitCollection.addHabit(newHabit);

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
