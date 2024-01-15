import java.util.Scanner;

public class Assignment3a {
    
    private static int totalPriority = 0;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the list of contents from rucksacks
        while (scanner.hasNextLine()) {
            String contents = scanner.nextLine();

            // Process the contents of each rucksack
            processRucksackContents(contents);
        }
        System.out.println("Sum of all Priority of rucksacks: " + totalPriority);
    }

    private static void processRucksackContents(String contents) {
        int length = contents.length();
        int halfLength = length / 2;

        // Extract contents of the first and second compartments
        String compartment1 = contents.substring(0, halfLength);
        String compartment2 = contents.substring(halfLength);

        // Find the common item type
        char commonItemType = findCommonItemType(compartment1, compartment2);

        // Calculate and print the priority
        int priority = calculatePriority(commonItemType);
        // System.out.println("Priority for rucksack: " + priority);
        totalPriority += priority; 
    }

    private static char findCommonItemType(String compartment1, String compartment2) {
        for (char item : compartment1.toCharArray()) {
            if (compartment2.contains(String.valueOf(item))) {
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
