// Placeholder class

import java.time.LocalDate;
import java.util.ArrayList;

public class Habit {

    // Initializing variables
    private String name;
    private String description;
    private HabitCategory category;
    private LocalDate creationDate;
    private ArrayList<LocalDate> completionDates;
    private int currentStreak;
    private int longestStreak;

    // Constructor for adding new habits
    public Habit(String name, String description, HabitCategory category){
        this.name = name;
        this.description = description;
        this.category = category;
        this.creationDate = LocalDate.now();
        this.completionDates = new ArrayList<>();
        this.currentStreak = 0;
        this.longestStreak = 0;
    }

    // Method to add completion to dates without date provided
    public void markCompleteNow(){
        completionDates.add(LocalDate.now());
    }
}