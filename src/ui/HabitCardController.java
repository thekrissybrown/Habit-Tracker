package ui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import model.Habit;

import java.time.LocalDate;

/**
 * Controller for an enhanced habit card with name, streak, and a toggle action.
 */
public class HabitCardController {

    @FXML private Label habitNameLabel;
    @FXML private Label streakLabel;
    @FXML private ToggleButton doneToggle;
    @FXML private Button editButton;

    private Habit habit;

    /**
     * Sets the habit to be represented by this UI card.
     * @param habit the habit object
     */
    public void setHabit(Habit habit) {
        this.habit = habit;
        habitNameLabel.setText(habit.getName());
        updateStreakDisplay();

        // Pre-check if today's date is already in the completion list
        doneToggle.setSelected(habit.getCompletionDates().contains(LocalDate.now()));
    }

    @FXML
    private void handleToggleDone() {
        boolean markedDone = doneToggle.isSelected();
        LocalDate today = LocalDate.now();

        try {
            if (markedDone) {
                habit.markCompletedToday();  // now handles streak checking internally
            } else {
                habit.getCompletionDates().remove(today);
                habit.checkStreak(); // re-check streak if undoing completion
            }
        } catch (IllegalArgumentException e) {
            // Prevent crash if the user tries to mark a duplicate
            System.out.println("Toggle failed: " + e.getMessage());
        }

        updateStreakDisplay();
    }

    @FXML
    private void handleEditHabit() {
        // TODO: Add logic to open an edit habit window (if needed)
        System.out.println("Edit Habit clicked: " + habit.getName());
    }

    private void updateStreakDisplay() {
        streakLabel.setText("\uD83D\uDD25 " + habit.getStreak() + " day streak");
    }
}
