// Project Name: Habit Tracker System
// Author: Mustafa Almajmaie
// Date: 2025-04-21
// This class manages a list of Habit objects with basic add, remove, and retrieve functionality.

package controller;

import model.Habit;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.Objects;
import java.io.Serializable;

/**
 * Represents a collection of Habit objects with basic management functionality.
 */
public class HabitCollection implements Serializable {

    private static final long serialVersionUID = 1L;

    private final List<Habit> habits;

    /**
     * Default constructor. Initializes the habit list with a thread-safe implementation.
     */
    public HabitCollection() {
        habits = new CopyOnWriteArrayList<>();
    }

    /**
     * Adds a new habit to the collection.
     *
     * @param habit the habit to add
     * @throws IllegalArgumentException if the habit is null or already exists in the collection
     */
    public void addHabit(Habit habit) {
        Objects.requireNonNull(habit, "Habit cannot be null");
        if (habits.contains(habit)) {
            throw new IllegalArgumentException("Habit already exists in the collection");
        }
        habits.add(habit);
    }

    /**
     * Removes a habit from the collection.
     *
     * @param habit the habit to remove
     * @throws IllegalArgumentException if the habit is null or doesn't exist in the collection
     */
    public void removeHabit(Habit habit) {
        Objects.requireNonNull(habit, "Habit cannot be null");
        if (!habits.remove(habit)) {
            throw new IllegalArgumentException("Habit not found in the collection");
        }
    }

    /**
     * Returns an unmodifiable view of all habits in the collection.
     *
     * @return unmodifiable list of habits
     */
    public List<Habit> getAllHabits() {
        return Collections.unmodifiableList(habits);
    }

    /**
     * Returns the number of habits in the collection.
     *
     * @return the size of the habit collection
     */
    public int getSize() {
        return habits.size();
    }

    /**
     * Checks if the collection is empty.
     *
     * @return true if the collection contains no habits, false otherwise
     */
    public boolean isEmpty() {
        return habits.isEmpty();
    }
}