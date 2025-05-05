package analytics;

// Habit Tracker Project
// Author: Kat Nunez
// Date: 2025-05-04
// Refactored to aggregate statistics across all habits.

import controller.HabitCollection;
import model.Habit;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 * Aggregates historical statistics across a collection of habits.
 */
public class StreakAnalyzer {

    /**
     * Calculates the total number of completions across all habits.
     */
    public static int getTotalCompletions(HabitCollection habits) {
        return habits.getAllHabits().stream()
                .mapToInt(h -> h.getCompletionDates().size())
                .sum();
    }

    /**
     * Calculates the completion percentage across a date range.
     */
    public static double getCompletionPercentage(HabitCollection habits, LocalDate startDate, LocalDate endDate) {
        long totalDays = ChronoUnit.DAYS.between(startDate, endDate) + 1;
        if (totalDays <= 0) return 0.0;

        Set<LocalDate> allCompletions = new HashSet<>();
        for (Habit h : habits.getAllHabits()) {
            for (LocalDate date : h.getCompletionDates()) {
                if (!date.isBefore(startDate) && !date.isAfter(endDate)) {
                    allCompletions.add(date);
                }
            }
        }

        return (allCompletions.size() / (double) totalDays) * 100;
    }

    /**
     * Finds the longest consecutive streak across all habits.
     */
    public static int getLongestStreakAcrossHabits(HabitCollection habits) {
        Set<LocalDate> allCompletionDates = new TreeSet<>();
        for (Habit h : habits.getAllHabits()) {
            allCompletionDates.addAll(h.getCompletionDates());
        }

        int longest = 0;
        int current = 0;
        LocalDate previous = null;

        for (LocalDate date : allCompletionDates) {
            if (previous != null && date.equals(previous.plusDays(1))) {
                current++;
            } else {
                current = 1;
            }
            longest = Math.max(longest, current);
            previous = date;
        }

        return longest;
    }

    /**
     * Placeholder for optional streak trends over time.
     */
    public static Map<String, Integer> getStreakTrends(HabitCollection habits) {
        // Optional: return trends by week/month (not implemented yet)
        return new HashMap<>();
    }
}
