// Habit Tracker Project
// Author: Mustafa Almajmaie
// Date: 2025-06-24
//Habit Collection Test

package test;

import controller.HabitCollection;
import model.Habit;
import model.HabitCategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the HabitCollection class.
 */

public class HabitCollectionTest {
    private HabitCollection habitCollection;

    @BeforeEach
    public void setUp() {
        habitCollection = new HabitCollection();
    }

    @Test
    public void testAddHabit() {
        Habit habit = new Habit("Exercise", "Daily workout", new HabitCategory("Health", "Physical"));
        habitCollection.addHabit(habit);
        assertTrue(habitCollection.getAllHabits().contains(habit));
    }

    @Test
    public void testRemoveHabit() {
        Habit habit = new Habit("Exercise", "Daily workout", new HabitCategory("Health", "Physical"));
        habitCollection.addHabit(habit);
        habitCollection.removeHabit(habit);
        assertFalse(habitCollection.getAllHabits().contains(habit));
    }

    @Test
    public void testGetAllHabits() {
        Habit habit1 = new Habit("Exercise", "Daily workout", new HabitCategory("Health", "Physical"));
        Habit habit2 = new Habit("Read", "Daily reading", new HabitCategory("Education", "Mental"));
        habitCollection.addHabit(habit1);
        habitCollection.addHabit(habit2);

        List<Habit> allHabits = habitCollection.getAllHabits();
        assertTrue(allHabits.contains(habit1));
        assertTrue(allHabits.contains(habit2));
    }
}