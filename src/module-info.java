module HabitTracker {
    requires javafx.controls;
    requires javafx.fxml;
    
    opens ui to javafx.fxml;
    exports ui;
    exports model;
    exports controller;
    exports analytics;
}
