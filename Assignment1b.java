import java.util.Scanner;
import java.util.PriorityQueue;

public class Assignment1b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a priority queue to keep track of the top three Elves
        PriorityQueue<Integer> topElves = new PriorityQueue<>(3);

        int currentElfCalories = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();

            if (line.isEmpty()) {
                // Blank line, end of Elf's inventory
                if (topElves.size() < 3) {
                    topElves.add(currentElfCalories);
                } else if (currentElfCalories > topElves.peek()) {
                    topElves.poll();
                    topElves.add(currentElfCalories);
                }

                currentElfCalories = 0; // Reset currentElfCalories for the next Elf
            } else {
                // Parse the Calories from the line and add to currentElfCalories
                int calories = Integer.parseInt(line);
                currentElfCalories += calories;
            }
        }

        // Check the last Elf's Calories in case there is no blank line at the end
        if (topElves.size() < 3) {
            topElves.add(currentElfCalories);
        } else if (currentElfCalories > topElves.peek()) {
            topElves.poll();
            topElves.add(currentElfCalories);
        }

        // Calculate the total Calories carried by the top three Elves
        int totalTopElfCalories = 0;
        while (!topElves.isEmpty()) {
            totalTopElfCalories += topElves.poll();
        }

        System.out.println("Total Calories carried by the top three Elves: " + totalTopElfCalories);
    }
}
