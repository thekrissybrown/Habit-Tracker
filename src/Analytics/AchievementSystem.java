package Analytics;

/*
 * Habit Tracker
 * Author: Kat Nunez
 * Date: April 24, 2025
 * Description: Awards achievements and tracks milestones based on habit performance.
 */

public class AchievementSystem {
    
    private boolean milestoneAchieved;
    private String lastBadgeAwarded;

    // Default constructor
    public AchievementSystem() {
        this.milestoneAchieved = false;
        this.lastBadgeAwarded = "";
    }

    // Parameterized constructor
    public AchievementSystem(boolean milestoneAchieved, String lastBadgeAwarded) {
        this.milestoneAchieved = milestoneAchieved;
        this.lastBadgeAwarded = lastBadgeAwarded;
    }

    // Returns true if a milestone has been achieved
    public boolean isMilestoneAchieved() {
        return milestoneAchieved;
    }

    // Sets milestone achievement status
    public void setMilestoneAchieved(boolean milestoneAchieved) {
        this.milestoneAchieved = milestoneAchieved;
    }

    // Returns the name of the last badge awarded
    public String getLastBadgeAwarded() {
        return lastBadgeAwarded;
    }

    // Sets the name of the last badge awarded
    public void setLastBadgeAwarded(String lastBadgeAwarded) {
        this.lastBadgeAwarded = lastBadgeAwarded;
    }
}
