package model;

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
    public void markCompletedToday(){
        // Need to add if it's been completed already.
        completionDates.add(LocalDate.now());
    }

    // Adds a past date to completion dates
    public void markCompletedPast(LocalDate date){
        // Need to add if it's been completed on that date already.
        completionDates.add(date);
    }

    @Override
    public String toString(){
        return String.format("Habit name: %s \n Habit description: %s \n Habit category: %s \n Creation date: %s \n Times completed: %s",
                name, description, category.getName(), creationDate, completionDates.size());
    }
}