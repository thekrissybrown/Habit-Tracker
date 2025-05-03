// Habit Tracker Project
// Author: Michal Broniek
// Date: 04-25-25
// Class for creating habit categories and returning habit category information

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

    // Setters for updating after creation
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("Name: %s \n Description: %s", name, description);
    }
}
