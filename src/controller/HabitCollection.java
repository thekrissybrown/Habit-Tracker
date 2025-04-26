// Project Name: Habit Tracker System
// Author: Mustafa Almajmaie
// Date: 2025-04-21
//This class manages a list of Habit objects, providing functionality for adding, removing, and retrieving habits.


package controller;

import model.Habit;
import java.util.ArrayList;
import java.util.List;

public class HabitCollection {

    private List<Habit> habits;

    /**
     * Default constructor. Initializes the habit list.
     */
    public HabitCollection() {
        habits = new ArrayList<>();
    }

    /**
     * Adds a new habit to the collection.
     * @param habit the habit to add
     */
    public void addHabit(Habit habit) {
        // to be implemented
    }

    /**
     * Removes a habit from the collection.
     * @param habit the habit to remove
     */
    public void removeHabit(Habit habit) {
        // to be implemented
    }

    /**
     * Returns the list of all habits.
     * @return list of habits
     */
    public List<Habit> getAllHabits() {
        return habits;
    }
}
