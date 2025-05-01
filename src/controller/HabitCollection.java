// Project Name: Habit Tracker System
// Author: Mustafa Almajmaie
// Date: 2025-04-21
// This class manages a list of Habit objects with basic add, remove, and retrieve functionality.

package controller;

import model.Habit;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Manages a collection of Habit objects with add, remove, filter, and sort functionalities.
 */
public class HabitCollection implements Serializable {

    private static final long serialVersionUID = 1L;

    private final List<Habit> habits;

    /**
     * Initializes an empty habit collection using ArrayList.
     */
    public HabitCollection() {
        this.habits = new ArrayList<>();
    }

    /**
     * Adds a habit to the collection.
     *
     * @param habit the habit to add
     * @throws IllegalArgumentException if habit is null or already exists
     */
    public void addHabit(Habit habit) {
        Objects.requireNonNull(habit, "Habit cannot be null");
        if (habits.contains(habit)) {
            throw new IllegalArgumentException("Habit already exists");
        }
        habits.add(habit);
    }

    /**
     * Adds multiple habits to the collection.
     *
     * @param habitList list of habits to add
     */
    public void addAllHabits(Collection<Habit> habitList) {
        for (Habit habit : habitList) {
            addHabit(habit);
        }
    }

    /**
     * Removes a habit from the collection.
     *
     * @param habit the habit to remove
     * @throws IllegalArgumentException if habit is null or not found
     */
    public void removeHabit(Habit habit) {
        Objects.requireNonNull(habit, "Habit cannot be null");
        if (!habits.remove(habit)) {
            throw new IllegalArgumentException("Habit not found");
        }
    }

    /**
     * Returns an unmodifiable list of all habits.
     */
    public List<Habit> getAllHabits() {
        return Collections.unmodifiableList(habits);
    }

    /**
     * Finds a habit by name (case-insensitive).
     */
    public Habit findHabitByName(String name) {
        return habits.stream()
                .filter(h -> h.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    /**
     * Filters habits that contain the provided keyword in their name (case-insensitive).
     */
    public List<Habit> filterHabits(String keyword) {
        return habits.stream()
                .filter(h -> h.getName().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    /**
     * Returns a new list of habits sorted by name.
     */
    public List<Habit> getHabitsSortedByName() {
        return habits.stream()
                .sorted(Comparator.comparing(Habit::getName, String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList());
    }

    /**
     * Returns the number of habits.
     */
    public int getSize() {
        return habits.size();
    }

    /**
     * Checks if the collection is empty.
     */
    public boolean isEmpty() {
        return habits.isEmpty();
    }

    /**
     * Clears all habits from the collection.
     */
    public void clear() {
        habits.clear();
    }
}
