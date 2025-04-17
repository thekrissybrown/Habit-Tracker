# Habit Tracker

## Project Overview
A Java-based application designed to help users build positive habits by tracking daily activities and maintaining streaks. This intuitive habit tracking tool allows users to create customizable habits, monitor their progress, and visualize their success through an interactive graphical interface.

## Potential Features
- **Habit Management**: Create, edit, and delete custom habits with personalized frequency goals
- **Daily Check-ins**: Mark habits as complete with a simple click
- **Streak Tracking**: Automatically calculate and display current streaks for each habit
- **Visual Progress**: View your habit completion history through intuitive calendar displays
- **Statistics Dashboard**: Monitor your success rates and longest streaks
- **Achievement System**: Earn badges and rewards for reaching habit milestones
- **Data Persistence**: Save and load your habit data between sessions

## Project Structure

### Source Files
- `Habit.java`: Core class representing individual habits with properties like name, description, frequency, and streak data (Developed by Krissy Brown)
- `HabitCollection.java`: Manages the collection of habits using ArrayList, handles sorting and filtering (Developed by Mustafa Almajmaie)
- `StreakAnalyzer.java`: Processes habit data to calculate statistics, streaks, and achievements (Developed by Michael Broniek)
- `HabitTrackerUI.java`: Creates and manages the graphical user interface (Developed by Michael Broniek)
- `Main.java`: Entry point for the application that initializes components

### Interface Functionality
- **Main Dashboard**: Displays all habits with current streak information and completion status
- **Habit Creation Form**: Interface for adding new habits with customizable parameters
- **Calendar View**: Visual representation of habit completion history by day/week/month
- **Statistics Panel**: Shows detailed analytics about habit performance over time
- **Settings Menu**: Customize application preferences and notification settings

## How to Run the Application
1. Download the `HabitTracker.jar` file from the repository
2. Ensure you have Java Runtime Environment (JRE) version 11 or higher installed
3. Double-click the JAR file or run via command line: `java -jar HabitTracker.jar`
4. If the JAR file doesn't execute, see the screenshots in the `/media` folder to view the application

## Development Information
- **Java Version**: Java SE 17
- **External Libraries**:
  - JavaFX 17.0.2 (for UI components)
  - JUnit 5.8.1 (for testing)

## Screenshots
Future Screenshots of the application will be found in the `/media` folder, showing:
- Main dashboard interface
- Habit creation process
- Calendar view
- Statistics dashboard
- Achievement system

## Future Enhancements
- Mobile companion application
- Cloud synchronization
- Social sharing features
- Advanced habit pattern analysis
- Custom notification scheduling

## Contributors
- **Krissy Brown**: User Interface & Integration: HabitTrackerUI.java, Main.java (JavaFX entry point)
- **Mustafa Almajmaie**: Collection Management & Persistence: HabitCollection.java, DataManager.java
- **Michael Broniek**: Habit Core & Data Model: Habit.java, HabitCategory.java
- **Kat Nunez**: Analytics & Achievement System: StreakAnalyzer.java, AchievementSystem.java

## Detailed Roles & Responsibilities

### Krissy Brown – User Interface & Integration
- Designed and implemented the graphical user interface (GUI) using JavaFX
- Developed `HabitTrackerUI.java` to provide a user-friendly dashboard and calendar view
- Managed `Main.java` to handle application startup and scene switching
- Integrated all modules into a cohesive application experience
- Participated in UI/UX testing and documentation

### Mustafa Almajmaie – Collection Management & Persistence
- Developed `HabitCollection.java` to manage the habit list using ArrayList with sorting/filtering
- Built `DataManager.java` to handle saving/loading habits with file I/O
- Ensured data persistence across sessions using Java serialization (or alternative method)
- Wrote unit tests to validate data integrity and file operations
- Documented methods and collaborated on error handling

### Michael Broniek – Habit Core & Data Model
- Created `Habit.java` to represent individual habit objects with attributes like name, streak, and frequency
- Implemented `HabitCategory.java` to organize habits into groups
- Wrote constructors, setters/getters, and helper methods for manipulating habit data
- Developed unit tests to validate core class functionality
- Documented model logic and assisted with structural planning

### Kat Nunez – Analytics & Achievement System
- Implemented `StreakAnalyzer.java` to calculate current streaks, completion rates, and historical performance
- Developed `AchievementSystem.java` to award badges and track milestones
- Integrated analytics with UI components for real-time feedback
- Wrote unit tests for streak logic and achievement conditions
- Collaborated on feature planning and progress tracking


## Acknowledgments


*This project was developed as part of the Java Programming course (C211) at Indiana University, Spring 2025.*
