// Habit Tracker Project
// Author: Mustafa Almajmaie
// Date: 2025-06-24
//Habit Collection Test
package test;

import controller.HabitCollection;
import controller.FileDataManager;
import model.Habit;
import model.HabitCategory;

import java.time.LocalDate;
import java.util.List;

public class HabitCollectionTest {

    public static void main(String[] args) {
        HabitCollection collection = new HabitCollection();

        Habit habit1 = new Habit("Workout", "Go to the gym", new HabitCategory("Health"));
        habit1.setCreationDate(LocalDate.of(2023, 1, 10));

        Habit habit2 = new Habit("Meditation", "10 minutes of mindfulness", new HabitCategory("Mental"));
        habit2.setCreationDate(LocalDate.of(2023, 1, 5));

        Habit habit3 = new Habit("Read", "Read 30 pages of a book", new HabitCategory("Learning"));
        habit3.setCreationDate(LocalDate.of(2023, 1, 12));

        collection.addHabit(habit1);
        collection.addHabit(habit2);
        collection.addHabit(habit3);

        // Print all habits
        System.out.println(" All Habits:");
        collection.getAllHabits().forEach(System.out::println);

        // Test filter
        System.out.println("\n Filter by 'med':");
        List<Habit> filtered = collection.filterHabits("med");
        filtered.forEach(System.out::println);

        // Test sort by name
        System.out.println("\n Sorted by name:");
        collection.getHabitsSortedByName().forEach(System.out::println);

        // Test sort by date
        System.out.println("\n Sorted by creation date:");
        collection.getHabitsSortedByDate().forEach(System.out::println);

        // Save to file (optional)
        FileDataManager.save(collection);

        // Load back from file (optional)
        HabitCollection loaded = FileDataManager.load();
        System.out.println("\n Reloaded habits from file:");
        loaded.getAllHabits().forEach(System.out::println);
    }
}
