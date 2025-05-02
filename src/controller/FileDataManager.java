// Habit Tracker Project
// Author: Mustafa Almajmaie
// Date: 2025-04-24
// Responsible for loading and saving HabitCollection data to a CSV file.

package controller;

import model.Habit;
import model.HabitCategory;

import java.io.*;
import java.time.LocalDate;
import java.util.Arrays;

public class FileDataManager {

    private static final String DATA_FILE = "data/habits.csv";

    public static HabitCollection load() {
        HabitCollection collection = new HabitCollection();
        File file = new File(DATA_FILE);

        if (!file.exists()) {
            System.out.println("No existing CSV data file. Starting fresh.");
            return collection;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", -1);
                if (parts.length >= 5) {
                    String name = unescapeCSV(parts[0]);
                    String description = unescapeCSV(parts[1]);
                    HabitCategory category = new HabitCategory(unescapeCSV(parts[2]));
                    LocalDate creationDate = LocalDate.parse(parts[3]);

                    Habit habit = new Habit(name, description, category);
                    habit.setCreationDate(creationDate);

                    if (!parts[4].isEmpty()) {
                        Arrays.stream(parts[4].split(";"))
                                .map(LocalDate::parse)
                                .forEach(habit::markCompletedPast);
                    }

                    collection.addHabit(habit);
                }
            }

        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }

        return collection;
    }

    public static void save(HabitCollection habitCollection) {
        File file = new File(DATA_FILE);
        file.getParentFile().mkdirs();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Habit habit : habitCollection.getAllHabits()) {
                String completedDates = String.join(";",
                        habit.getCompletionDates().stream()
                                .map(LocalDate::toString)
                                .toArray(String[]::new)
                );

                String line = String.join(",",
                        escapeCSV(habit.getName()),
                        escapeCSV(habit.getDescription()),
                        escapeCSV(habit.getCategory().getName()),
                        habit.getCreationDate().toString(),
                        completedDates
                );

                writer.write(line);
                writer.newLine();
            }

        } catch (IOException e) {
            System.err.println("Error writing CSV file: " + e.getMessage());
        }
    }

    private static String escapeCSV(String value) {
        if (value.contains(",") || value.contains("\"") || value.contains("\n")) {
            value = value.replace("\"", "\"\"");
            return "\"" + value + "\"";
        }
        return value;
    }

    private static String unescapeCSV(String value) {
        if (value.startsWith("\"") && value.endsWith("\"")) {
            value = value.substring(1, value.length() - 1);
            return value.replace("\"\"", "\"");
        }
        return value;
    }
}
