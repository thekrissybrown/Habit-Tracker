package ui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
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

    @FXML private Label habitNameLabel;
    @FXML private Label streakLabel;
    @FXML private ToggleButton doneToggle;
    @FXML private Button editButton;

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
        updateStreakDisplay();

        // Pre-select toggle if already completed today
        doneToggle.setSelected(habit.getCompletionDates().contains(LocalDate.now()));
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

    @FXML
    private void handleEditHabit() {
        // Placeholder for future edit UI
        System.out.println("Edit habit clicked: " + habit.getName());
    }

    // ───────────────────────────────────────────────────────────────
    // 🔁 Helper Methods
    // ───────────────────────────────────────────────────────────────

    /**
     * Updates the streak label visually.
     */
    private void updateStreakDisplay() {
        streakLabel.setText("\uD83D\uDD25 " + habit.getStreak() + " day streak");
    }
}
