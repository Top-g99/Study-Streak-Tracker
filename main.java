import model.Streak;
import service.StreakService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StreakService streakService = new StreakService();
        Streak streak = streakService.loadStreak();

        while (true) {
            System.out.println("\n📚 Welcome to Study Streak Tracker!");
            System.out.println("1. Log today's study");
            System.out.println("2. View streak status");
            System.out.println("3. Exit");
            System.out.print("> ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    streakService.logToday(streak);
                    break;
                case 2:
                    streakService.viewStreak(streak);
                    break;
                case 3:
                    System.out.println("👋 Keep up the great work! Bye!");
                    return;
                default:
                    System.out.println("❌ Invalid option. Try again.");
            }
        }
    }
}
