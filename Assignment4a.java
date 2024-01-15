import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Assignment4a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> input = new ArrayList<>();

        // Read input lines until an empty line is encountered
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                break;
            }
            input.add(line);
        }

        int countFullyContainedPairs = countFullyContainedPairs(input);
        System.out.println("Number of assignment pairs where one range fully contains the other: " + countFullyContainedPairs);
    }

    private static int countFullyContainedPairs(List<String> input) {
        int count = 0;

        for (String pair : input) {
            String[] assignments = pair.split(",");
            String[] range1 = assignments[0].split("-");
            String[] range2 = assignments[1].split("-");

            int start1 = Integer.parseInt(range1[0]);
            int end1 = Integer.parseInt(range1[1]);
            int start2 = Integer.parseInt(range2[0]);
            int end2 = Integer.parseInt(range2[1]);

            // Check if one range fully contains the other
            if ((start1 <= start2  && end2 <= end1) || (start2 <= start1  && end1 <= end2) ) {
                count++;
            }
        }

        return count;
    }
}
