import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Assignment2a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the strategy guide
        List<String[]> strategyGuide = new ArrayList<>();

        while (scanner.hasNext()) {
            String opponentMove = scanner.next();
            String yourMove = scanner.next();

            // Check for the end of input
            if (opponentMove.isEmpty() && yourMove.isEmpty()) {
                break;
            }

            // Add the moves to the strategy guide
            strategyGuide.add(new String[]{opponentMove, yourMove});
        }

        // Calculate total score
        int totalScore = calculateTotalScore(strategyGuide);

        System.out.println("Total Score: " + totalScore);
    }

    private static int calculateTotalScore(List<String[]> strategyGuide) {
        int totalScore = 0;

        for (String[] moves : strategyGuide) {
            String opponentMove = moves[0];
            String yourMove = moves[1];

            int yourScore = getScore(yourMove);
            int outcomeScore = getOutcomeScore(opponentMove, yourMove);

            totalScore += yourScore + outcomeScore;
        }

        return totalScore;
    }

    private static int getScore(String move) {
        switch (move) {
            case "X": return 1; // Rock
            case "Y": return 2; // Paper
            case "Z": return 3; // Scissors
            default: return 0; // Unknown move
        }
    }

    private static int getOutcomeScore(String opponentMove, String yourMove) {
        switch (opponentMove) {
            case "A":
                if (yourMove.equals("X")) {
                    return 3;
                } else if (yourMove.equals("Y")) {
                    return 6; // Paper
                } else {
                    return 0;
                }
            case "B":
                if (yourMove.equals("Y")) {
                    return 3;
                } else if (yourMove.equals("Z")) {
                    return 6; // Scissor
                } else {
                    return 0;
                }
            case "C":
                if (yourMove.equals("Z")) {
                    return 3;
                } else if (yourMove.equals("X")) {
                    return 6; // Rock
                } else {
                    return 0;
                }
            default:
                return 0;
        }
    }
}
