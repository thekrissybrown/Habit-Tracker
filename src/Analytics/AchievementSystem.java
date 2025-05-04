package analytics;

// Habit Tracker Project
// Author: Kat Nunez
// Date: 2025-05-04
// Awards achievements based on aggregate statistics.


import controller.HabitCollection;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Evaluates user progress and returns a list of earned achievements.
 */
public class AchievementSystem {

    /**
     * Returns achievements earned based on user's habit stats.
     */
    public static List<String> evaluateAchievements(HabitCollection habits) {
        List<String> achievements = new ArrayList<>();

        int totalCompletions = StreakAnalyzer.getTotalCompletions(habits);
        int longestStreak = StreakAnalyzer.getLongestStreakAcrossHabits(habits);

        // Completion-based achievements
        if (totalCompletions >= 1) achievements.add("First Step Taken");
        if (totalCompletions >= 10) achievements.add("10 Completions");
        if (totalCompletions >= 50) achievements.add("50 Habits Done");
        if (totalCompletions >= 100) achievements.add("Century Club");

        // Streak-based achievements
        if (longestStreak >= 3) achievements.add("3-Day Warrior");
        if (longestStreak >= 7) achievements.add("One Week Streak");
        if (longestStreak >= 30) achievements.add("30-Day Powerhouse");
        if (longestStreak >= 100) achievements.add("100-Day Legend");

        // Consecutive daily activity across any habit
        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(1);
        LocalDate twoDaysAgo = today.minusDays(2);

        List<LocalDate> recentDates = new ArrayList<>();
        for (var h : habits.getAllHabits()) {
            recentDates.addAll(h.getCompletionDates());
        }

        if (recentDates.contains(today) &&
            recentDates.contains(yesterday) &&
            recentDates.contains(twoDaysAgo)) {
            achievements.add("3-Day Active Streak");
        }

        return achievements;
    }
}
