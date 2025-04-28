// Project Name: Habit Tracker System
// Author: Mustafa Almajmaie
// Date: 2025-04-25
// Description: This code is part of a habit tracker system that allows users to track their habits.

package controller;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Handles reading and writing habit data using Java object serialization.
 */
public class FileDataManager {

    private static final Path DATA_FILE_PATH = Paths.get("data", "habits.ser");

    /**
     * Loads the HabitCollection from file, or returns a new one if the file doesn't exist.
     * @return HabitCollection loaded from disk
     * @throws IOException if reading fails
     * @throws ClassNotFoundException if deserialization fails
     */
    public static HabitCollection load() throws IOException, ClassNotFoundException {
        if (!Files.exists(DATA_FILE_PATH)) {
            return new HabitCollection(); // empty collection if nothing saved yet
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(DATA_FILE_PATH.toFile()))) {
            return (HabitCollection) in.readObject();
        }
    }

    /**
     * Saves the HabitCollection to file using object serialization.
     * @param habitCollection the data to save
     * @throws IOException if writing fails
     */
    public static void save(HabitCollection habitCollection) throws IOException {
        // Make sure the data directory exists
        Files.createDirectories(DATA_FILE_PATH.getParent());

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(DATA_FILE_PATH.toFile()))) {
            out.writeObject(habitCollection);
        }
    }
}