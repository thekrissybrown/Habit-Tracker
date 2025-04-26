// Project Name: Habit Tracker System
// Author: Mustafa Almajmaie
// Date: 2025-04-21
// Description:// This class handles saving and loading habit data to and from a file.



package controller;

public class DataManager {
    private final String filePath;

    public DataManager(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Loads the habit collection from a file.
     *
     * @return the loaded HabitCollection object
     */
    public HabitCollection load() {
        // placeholder logic
        return new HabitCollection();
    }

    /**
     * Saves the habit collection to a file.
     *
     * @param collection the HabitCollection to save
     */
    public void save(HabitCollection collection) {
        // to be implemented
    }
}
