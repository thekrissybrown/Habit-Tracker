package ui; // ✅ Must match the folder it's in, e.g., src/ui/Main.java

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Habit Tracker");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args); // ✅ This is what IntelliJ needs to recognize it as a main class
    }
}

// ✅ The public class name must match the file name, e.g., Main.java
// ✅ The main method is the entry point of the application
// ✅ The start method is overridden to set up the primary stage (window) of the JavaFX application
// ✅ The launch method starts the JavaFX application