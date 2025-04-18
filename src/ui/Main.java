package ui; // 👈 Update this if your package is different

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Habit Tracker");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

