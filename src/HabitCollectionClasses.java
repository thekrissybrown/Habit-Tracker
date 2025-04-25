// Project Name: Habit Tracker System
// Author: Mustafa Almajmaie 
// Date: 2025-04-21
// Description: This file contains stubs for two classes - HabitCollection and DataManager. 
//              HabitCollection manages a list of Habit objects, while DataManager handles 
//              reading and writing Habit data to a file.

package HabitCollection

import java.util.ArrayList;

/* 
 * HabitCollection is responsible for managing an in-memory list of Habit objects.
 */
public class HabitCollection {
    private ArrayList<Habit> habits;

    /* 
     * Constructor initializes the habit list.
     */
    public HabitCollection() {
        habits = new ArrayList<>();
    }

    /* 
     * Adds a new habit to the list.
     */
    public void addHabit(Habit habit) {
        // To be implemented
    }

    /* 
     * Removes a habit by name.
     */
    public boolean removeHabit(String name) {
        // To be implemented
        return false;
    }

    /* 
     * Returns all habits.
     */
    public ArrayList<Habit> getAllHabits() {
        // To be implemented
        return null;
    }

    /* 
     * Sorts the habits by name.
     */
    public void sortHabitsByName() {
        // To be implemented
    }
}

/* 
 * DataManager is responsible for file I/O operations involving Habit data.
 */
class DataManager {

    /* 
     * Saves the list of habits to a file.
     */
    public static void saveHabitsToFile(ArrayList<Habit> habits, String filename) {
        // To be implemented
    }

    /* 
     * Loads a list of habits from a file.
     */
    public static ArrayList<Habit> loadHabitsFromFile(String filename) {
        // To be implemented
        return null;
    }
}
