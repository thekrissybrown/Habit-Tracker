package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Habit {
    private String name;
    private String description;
    private HabitCategory category;
    private LocalDate creationDate;
    private ArrayList<LocalDate> completionDates;

    // Constructor
    public Habit(String name, String description, HabitCategory category){
        this.name = name;
        this.description = description;
        this.category = category;
        this.creationDate = LocalDate.now();
        this.completionDates = new ArrayList<>();
    }

    // Getters for Habits
    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public HabitCategory getCategory(){
        return category;
    }

    public LocalDate getCreationDate(){
        return creationDate;
    }

    public ArrayList<LocalDate> getCompletionDates(){
        return completionDates;
    }


}