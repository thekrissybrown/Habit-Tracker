package analytics;

/*
 * Habit Tracker
 * Author: Kat Nunez
 * Date: April 24, 2025
 * Description: Processes habit data to calculate statistics, streaks, and achievements.
 */

public class StreakAnalyzer {
    
    private int currentStreak;
    private int longestStreak;

    // Default constructor
    public StreakAnalyzer() {
        this.currentStreak = 0;
        this.longestStreak = 0;
    }

    // Parameterized constructor
    public StreakAnalyzer(int currentStreak, int longestStreak) {
        this.currentStreak = currentStreak;
        this.longestStreak = longestStreak;
    }

    // Returns the current streak count
    public int getCurrentStreak() {
        return currentStreak;
    }

    // Sets the current streak count
    public void setCurrentStreak(int currentStreak) {
        this.currentStreak = currentStreak;
    }

    // Returns the longest streak count
    public int getLongestStreak() {
        return longestStreak;
    }

    // Sets the longest streak count
    public void setLongestStreak(int longestStreak) {
        this.longestStreak = longestStreak;
    }
}
