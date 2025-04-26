// Habit Tracker Project
// Author: Michal Broniek
// Date: 04-25-25
// Class for creating habits, returning, adding current/past completion dates

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

    // Adds current date as a completion date
    // Checks if the date has already been added to the list.
    public void markCompletedToday(){
        if (completionDates.contains(LocalDate.now())){
            throw new RuntimeException("Task already completed today.");
        } else
            completionDates.add(LocalDate.now());
    }

    // Adds a past date to completion dates
    // Checks if the date has already been added to the list.
    public void markCompletedPast(LocalDate date){
        if (completionDates.contains(LocalDate.now())){
            throw new RuntimeException("Task already completed on that date.");
        } else
            completionDates.add(date);
    }

    @Override
    public String toString(){
        return String.format("Habit name: %s \n Habit description: %s \n Habit category: %s \n Creation date: %s \n Times completed: %s",
                name, description, category.getName(), creationDate, completionDates.size());
    }
}