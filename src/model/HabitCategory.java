package model;

public class HabitCategory {
    private String name;
    private String description;

    // Constructor
    public HabitCategory(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Getters for Habit Category
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString(){
        return "Category " + name + " " + description;
    }
}
