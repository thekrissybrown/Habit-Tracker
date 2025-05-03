// Habit Tracker Project
// Author: Krissy Brown
// Date: 2025-04-24
// Controller for the dashboard scene. Manages the display of tracked habits and transitions to the add habit form.

package ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    // ───────────────────────────────────────────────────────────────
    @FXML
    private Button addHabitButton;
    // ⚠️ Make sure dashboard.fxml uses fx:id="addHabitButton"
    @FXML
    private TilePane habitTilePane; // ⚠️ Make sure dashboard.fxml uses fx:id="habitTilePane"

    /**
     * Initializes the dashboard UI by loading all habits into styled cards.
     */
    @FXML
    public void initialize() {
        try {
            habitTilePane.getChildren().clear();

            for (Habit habit : Main.habitCollection.getAllHabits()) {
                URL fxmlUrl = getClass().getResource("/ui/HabitCard.fxml");
                if (fxmlUrl == null) {
                    throw new IOException("Could not find HabitCard.fxml in /ui/");
                }

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
     * Opens the "Add Habit" form in a new window.
     */
    @FXML
    private void handleAddHabitButton() {
        try {
            Parent addHabitView = FXMLLoader.load(getClass().getResource("/ui/addHabit.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Add New Habit");
            stage.setScene(new Scene(addHabitView));
            stage.centerOnScreen();
            stage.show();
        } catch (IOException e) {
            showError("Failed to open Add Habit form.", e);
        }
    }

    /**
     * Displays an error alert dialog with the given message and exception details.
     */
    private void showError(String message, Exception e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("UI Error");
        alert.setHeaderText(message);
        alert.setContentText(e.getMessage());
        alert.showAndWait();
    }
}
