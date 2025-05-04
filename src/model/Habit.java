// Habit Tracker Project
// Author: Michal Broniek
// Date: 04-25-25
// Class for creating habits, returning, adding current/past completion dates

package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Habit implements Serializable { //Added Serializable to allow compatibility with FileDataManager
    private String name;
    private String description;
    private HabitCategory category;
    private final LocalDate creationDate;
    private final ArrayList<LocalDate> completionDates;
    private int streak;
    private int longestStreak;
    private static final long serialVersionUID = 1L; // <-- SerialVersionUID for serialization
    // ───────────────────────────────────────────────────────────────
    // 🌱 Optional Emoji Tag (UI use only)
    // ───────────────────────────────────────────────────────────────
    private String emoji = "🌱"; // Default icon, can be customized


    // Constructor
    public Habit(String name, String description, HabitCategory category) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.creationDate = LocalDate.now();
        this.completionDates = new ArrayList<>();
        this.streak = 0;
        this.longestStreak = 0;
    }

    // Getters for Habits
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public HabitCategory getCategory() {
        return category;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public ArrayList<LocalDate> getCompletionDates() {
        return completionDates;
    }

    public int getStreak() {
        return streak;
    }

    public int getLongestStreak() {
        return longestStreak;
    }

    // Setters for Habits (In the case of updating after it has been added)
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(HabitCategory category) {
        this.category = category;
    }

    // Adds current date as a completion date
    // Checks if the date has already been added to the list.
    // Sorts and checks for a streak
    public void markCompletedToday() {
        LocalDate today = LocalDate.now();
        if (completionDates.contains(today)) {
            throw new IllegalArgumentException("Habit " + name + " has already been completed today.");
        } else {
            completionDates.add(today);
            completionDates.sort(null);
            checkStreak();
        }
    }

    // Adds a past date to completion dates
    // Checks if the date has already been added to the list.
    // Sorts and checks for a streak
    public void markCompletedPast(LocalDate date) {
        LocalDate today = LocalDate.now();
        if (date.isAfter(today)) {
            throw new IllegalArgumentException("Cannot mark completion for a future date.");
        }
        if (completionDates.contains(date)) {
            throw new IllegalArgumentException("Habit " + name + " has already been completed on " + date);
        } else {
            completionDates.add(date);
            completionDates.sort(null);
            checkStreak();
        }
    }

    @Override
    public String toString() {
        return String.format("Habit name: %s \n Habit description: %s \n Habit category: %s \n Creation date: %s \n Times completed: %s",
                name, description, category.getName(), creationDate, completionDates.size());
    }

    // Method to look through list of completions to check if there is a streak
    public void checkStreak() {
        if (completionDates.isEmpty()) {
            streak = 0;
            return;
        }

        completionDates.sort(null);

        LocalDate today = LocalDate.now();
        LocalDate latestCompletion = completionDates.getLast();

        if (!latestCompletion.isEqual(today) && !latestCompletion.isEqual(today.minusDays(1))) {
            streak = 0;
            return;
        }

        int currentStreak = 0;
        for (int i = completionDates.size() - 1; i >= 0; i--) {
            LocalDate dateInList = completionDates.get(i);
            LocalDate expectedDate = latestCompletion.minusDays(currentStreak);
            if (dateInList.isEqual(expectedDate)) {
                currentStreak++;
            } else if (dateInList.isBefore(expectedDate)) {
                break;
            }
        }
        streak = currentStreak;
        if (streak > longestStreak)
            longestStreak = streak;
    }// ───────────────────────────────────────────────────────────────
    // 🔄 Emoji Accessors
    // ───────────────────────────────────────────────────────────────
    public String getEmoji() {
        return emoji;
    }
    public void setEmoji(String emoji) {
        this.emoji = emoji;
    }
}