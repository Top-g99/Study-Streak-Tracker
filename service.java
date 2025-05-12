package service;

import model.Streak;
import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class StreakService {
    private final String filePath = "streak_data.txt";

    public Streak loadStreak() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            int count = Integer.parseInt(reader.readLine());
            LocalDate lastDate = LocalDate.parse(reader.readLine());
            return new Streak(count, lastDate);
        } catch (Exception e) {
            // If file doesn't exist or is corrupted, return new streak
            return new Streak(0, LocalDate.now().minusDays(1));
        }
    }

    public void saveStreak(Streak streak) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(String.valueOf(streak.getCount()));
            writer.newLine();
            writer.write(streak.getLastDate().toString());
        } catch (IOException e) {
            System.out.println("Error saving streak.");
        }
    }

    public void logToday(Streak streak) {
        LocalDate today = LocalDate.now();
        long daysBetween = ChronoUnit.DAYS.between(streak.getLastDate(), today);

        if (daysBetween == 1) {
            streak.increment();
            System.out.println("🔥 Great! You're on a " + streak.getCount() + "-day streak!");
        } else if (daysBetween > 1) {
            streak.reset();
            System.out.println("⚠️ Streak reset. But don’t give up! New streak started.");
        } else if (daysBetween == 0) {
            System.out.println("✅ You've already logged your study for today.");
        }

        saveStreak(streak);
    }

    public void viewStreak(Streak streak) {
        System.out.println("📊 Current Streak: " + streak.getCount() + " day(s)");
        System.out.println("📅 Last Logged: " + streak.getLastDate());
    }
}
