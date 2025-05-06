// Habit Tracker Project
// Author: Krissy Brown
// Date: 2025-04-24
// Controller for the dashboard scene. Manages the display of tracked habits and transitions to the add habit form.

package ui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import model.Habit;

import java.io.IOException;
import java.net.URL;

public class HabitTrackerUI {

    @FXML private Button addHabitButton;
    @FXML private TilePane habitTilePane;
    @FXML private Button viewAchievementsButton;
    @FXML private Button settingsButton;

    /**
     * Populates the dashboard with habit cards.
     */
    @FXML
    public void initialize() {
        try {
            habitTilePane.getChildren().clear();

            for (Habit habit : Main.habitCollection.getAllHabits()) {
                URL fxmlUrl = getClass().getResource("/ui/HabitCard.fxml");
                if (fxmlUrl == null) throw new IOException("Missing FXML: /ui/HabitCard.fxml");

                FXMLLoader loader = new FXMLLoader(fxmlUrl);
                Parent card = loader.load();
                HabitCardController controller = loader.getController();
                controller.setHabit(habit);
                habitTilePane.getChildren().add(card);
            }
        } catch (IOException e) {
            showError("Failed to load habit cards.", e);
        }
    }

    /**
     * Opens the Add Habit window and wires back the dashboard controller.
     */
    @FXML
    private void handleAddHabitButton() {
        try {
            URL fxmlUrl = getClass().getResource("/ui/addHabit.fxml");
            if (fxmlUrl == null) throw new IOException("Missing FXML: /ui/addHabit.fxml");

            FXMLLoader loader = new FXMLLoader(fxmlUrl);
            Parent addHabitView = loader.load();

            // ✅ Wire up controller
            AddHabitController controller = loader.getController();
            controller.setDashboardController(this);

            Stage stage = new Stage();
            stage.setTitle("Add New Habit");
            stage.setScene(new Scene(addHabitView));
            stage.centerOnScreen();
            stage.show();
        } catch (IOException e) {
            showError("Failed to open Add Habit form.", e);
        }
    }

    @FXML
    private void handleViewAchievements() {
        try {
            var achievements = analytics.AchievementSystem.evaluateAchievements(Main.habitCollection);
            String content = achievements.isEmpty()
                    ? "No achievements earned yet. Keep going!"
                    : String.join("\n• ", achievements);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Your Achievements");
            alert.setHeaderText("🏆 Achievements You've Earned");
            alert.setContentText("• " + content);
            alert.showAndWait();
        } catch (Exception e) {
            showError("Failed to load achievements.", e);
        }
    }

    @FXML
    private void handleSettings() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Settings");
        alert.setHeaderText("⚙ Settings Panel");
        alert.setContentText("Settings functionality coming soon!");
        alert.showAndWait();
    }

    private void showError(String message, Exception e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("UI Error");
        alert.setHeaderText(message);
        alert.setContentText(e.getMessage());
        alert.showAndWait();
    }
}
