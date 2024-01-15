import java.util.Scanner;

public class Assignment1a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int currentElfCalories = 0;
        int maxElfCalories = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();

            if (line.isEmpty()) {
                // Blank line, the end of Elf's inventory
                maxElfCalories = Math.max(maxElfCalories, currentElfCalories);
                currentElfCalories = 0; // Reset currentElfCalories for the next Elf
            } else {
                // Parse the Calories from the line and add to currentElfCalories
                int calories = Integer.parseInt(line);
                currentElfCalories += calories;
            }
        }

        // Check the last Elf's Calories in case there is no blank line at the end
        maxElfCalories = Math.max(maxElfCalories, currentElfCalories);

        System.out.println("Elf carrying the most Calories: " + maxElfCalories);
    }
}
