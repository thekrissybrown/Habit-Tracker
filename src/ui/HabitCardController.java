package ui;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Habit;

import java.time.LocalDate;

/**
 * Controller for the habit card UI.
 * Handles marking completion and visualizing streaks.
 *
 * Author: Krissy Brown
 * Date: 2025-04-24
 */
public class HabitCardController {

    // ───────────────────────────────────────────────────────────────
    // 💬 FXML Fields
    // ───────────────────────────────────────────────────────────────

    @FXML private Label emojiLabel;
    @FXML private Label habitNameLabel;
    @FXML private Label streakLabel;
    @FXML private ToggleButton doneToggle;
    @FXML private Button editButton;
    @FXML private ProgressBar streakBar;

    // ───────────────────────────────────────────────────────────────
    // 📦 Internal Data
    // ───────────────────────────────────────────────────────────────

    private Habit habit;

    // ───────────────────────────────────────────────────────────────
    // 📋 Initialization
    // ───────────────────────────────────────────────────────────────

    /**
     * Injects the habit into the UI card and displays its data.
     * @param habit the habit model object
     */
    public void setHabit(Habit habit) {
        this.habit = habit;

        habitNameLabel.setText(habit.getName());
        emojiLabel.setText(habit.getEmoji() != null ? habit.getEmoji() : "🌱");

        doneToggle.setSelected(habit.getCompletionDates().contains(LocalDate.now()));

        updateStreakDisplay();
    }

    // ───────────────────────────────────────────────────────────────
    // ✅ Event Handlers
    // ───────────────────────────────────────────────────────────────

    @FXML
    private void handleToggleDone() {
        LocalDate today = LocalDate.now();

        try {
            if (doneToggle.isSelected()) {
                habit.markCompletedToday(); // Updates streak inside
            } else {
                habit.getCompletionDates().remove(today);
                habit.checkStreak(); // Manually recheck streak after removal
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Toggle error: " + e.getMessage());
        }

        updateStreakDisplay();
    }

    /**
     * Opens the settings form in a new window.
     */
    @FXML
    private void handleEditHabit() {
        // Placeholder for edit functionality
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Edit Habit");
        alert.setHeaderText("✏️ Edit Habit");
        alert.setContentText("Editing habits is coming soon!");
        alert.showAndWait();
    }



    // ───────────────────────────────────────────────────────────────
    // 🔁 Helper Methods
    // ───────────────────────────────────────────────────────────────

    /**
     * Updates the streak label and visual bar.
     */
    private void updateStreakDisplay() {
        int streak = habit.getStreak();
        int maxStreak = 30; // Cap for visualization purposes
        double progress = Math.min(1.0, streak / (double) maxStreak);

        streakLabel.setText("\uD83D\uDD25 " + streak + " day streak");

        if (streakBar != null) {
            streakBar.setProgress(progress);
        }
    }
}
