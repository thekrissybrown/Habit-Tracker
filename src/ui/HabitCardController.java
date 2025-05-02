// HabitCardController.java — Enhanced Version with Toggles, Icons, and Styling
package ui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import model.Habit;

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
     * Set up the habit data into UI components.
     * @param habit the habit object to display
     */
    public void setHabit(Habit habit) {
        this.habit = habit;

        habitNameLabel.setText(habit.getName());
        streakLabel.setText("\uD83D\uDD25 " + habit.getStreak() + " day streak");
        doneToggle.setSelected(false);
    }

    @FXML
    private void handleToggleDone() {
        boolean markedDone = doneToggle.isSelected();
        if (markedDone) {
            habit.incrementStreak();
        } else {
            habit.resetStreak();
        }
        streakLabel.setText("\uD83D\uDD25 " + habit.getStreak() + " day streak");
    }

    @FXML
    private void handleEditHabit() {
        // You can link this to open an edit form
        System.out.println("Editing habit: " + habit.getName());
    }
}
