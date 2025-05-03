// Habit Tracker Project
// Author: Mustafa Almajmaie
// Date: 2025-04-24
// Responsible for loading and saving HabitCollection data to a CSV file.



package controller;

import java.io.*;

/**
 * FileDataManager handles the persistence of HabitCollection using object serialization (.ser).
 */
public class FileDataManager {

    private static final String DATA_FILE = "data/habits.ser";

    /**
     * Loads the HabitCollection from a binary .ser file.
     *
     * @return HabitCollection from file, or a new one if file is missing or corrupted
     */
    public static HabitCollection load() {
        File file = new File(DATA_FILE);

        if (!file.exists()) {
            System.out.println(" No serialized data found. Starting with empty collection.");
            return new HabitCollection();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            HabitCollection collection = (HabitCollection) ois.readObject();
            System.out.println(" Habit collection loaded from " + DATA_FILE);
            return collection;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(" Error loading habit collection: " + e.getMessage());
            return new HabitCollection(); // fallback if corrupted or incompatible
        }
    }

    /**
     * Saves the HabitCollection to a binary .ser file.
     *
     * @param habitCollection the data to persist
     */
    public static void save(HabitCollection habitCollection) {
        File file = new File(DATA_FILE);
        file.getParentFile().mkdirs();

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(habitCollection);
            System.out.println(" Habit collection saved to " + DATA_FILE);
        } catch (IOException e) {
            System.err.println(" Error saving habit collection: " + e.getMessage());
        }
    }
}
