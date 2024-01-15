import java.util.Scanner;

public class Assignment3b {

    private static int totalPriority = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Process each group of three lines
        while (scanner.hasNextLine()) {
            String line1 = scanner.nextLine();

            // Check if there are enough lines to form a complete group
            if (scanner.hasNextLine()) {
                String line2 = scanner.nextLine();

                // Check if there is one more line to complete the group
                if (scanner.hasNextLine()) {
                    String line3 = scanner.nextLine();

                    // Process the group of three lines
                    processGroup(line1, line2, line3);
                } else {
                    System.out.println("Incomplete group found. Skipping...");
                }
            } else {
                System.out.println("Incomplete group found. Skipping...");
            }
        }

        System.out.println("Sum of all Priority of rucksacks: " + totalPriority);
    }

    private static void processGroup(String line1, String line2, String line3) {
        char commonItemType = findCommonItemType(line1, line2, line3);

        // Calculate and print the priority
        int priority = calculatePriority(commonItemType);
        totalPriority += priority;
    }

   private static char findCommonItemType(String line1, String line2, String line3) {
        for (char item : line1.toCharArray()) {
            if (line2.contains(String.valueOf(item)) && line3.contains(String.valueOf(item))) {
                return item;
            }
        }
        return ' '; // No common item found
    }


    private static int calculatePriority(char itemType) {
        if (Character.isLowerCase(itemType)) {
            return itemType - 'a' + 1;
        } else if (Character.isUpperCase(itemType)) {
            return itemType - 'A' + 27;
        } else {
            return 0; // Invalid item type
        }
    }
}
