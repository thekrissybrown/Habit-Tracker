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

public class AddHabitController {

    @FXML
    private TextField habitNameField;

    @FXML
    private TextField emojiField;

    @FXML
    private ComboBox<String> emojiPicker;

    @FXML
    private Label validationLabel;

    private HabitTrackerUI dashboardController; // ✅ link to UI controller

    /**
     * Injects a reference to the dashboard controller so we can refresh it after saving.
     */
    public void setDashboardController(HabitTrackerUI dashboardController) {
        this.dashboardController = dashboardController;
    }

    /**
     * Handles saving a new habit.
     */
    @FXML
    private void handleSaveHabit() {
        String name = habitNameField.getText().trim();
        String selectedEmoji = emojiPicker.getValue();

        if (name.isEmpty()) {
            validationLabel.setText("Habit name cannot be empty.");
            validationLabel.setStyle("-fx-text-fill: #9e1717;");
            return;
        }

        Habit newHabit = new Habit(name, "", null);
        newHabit.setEmoji(selectedEmoji != null ? selectedEmoji : "🌱");

        try {
            Main.habitCollection.addHabit(newHabit);

            // ✅ Refresh dashboard immediately
            if (dashboardController != null) {
                dashboardController.initialize();
            }

            Stage stage = (Stage) habitNameField.getScene().getWindow();
            stage.close();
        } catch (Exception e) {
            validationLabel.setText("Failed to save habit. Please try again.");
            validationLabel.setStyle("-fx-text-fill: #9e1717;");
        }
    }

    /**
     * Cancels and closes the form.
     */
    @FXML
    private void handleCancel() {
        Stage stage = (Stage) habitNameField.getScene().getWindow();
        stage.close();
    }
}
