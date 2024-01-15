import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Assignment2b {
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

            int yourScore = getOutcomeScore(yourMove);
            int outcomeScore = getScore(opponentMove, yourMove);

            totalScore += yourScore + outcomeScore;
        }

        return totalScore;
    }

    private static int getOutcomeScore(String move) {
        switch (move) {
            case "X": return 0; // Rock
            case "Y": return 3; // Paper
            case "Z": return 6; // Scissors
            default: return 0; // Unknown move
        }
    }

    private static int getScore(String opponentMove, String yourMove) {
        switch (opponentMove) {
            case "A":
                if (yourMove.equals("X")) {
                    return 3; //Scissor
                } else if (yourMove.equals("Y")) {
                    return 1; // Rock
                } else {
                    return 2;
                }
            case "B":
                if (yourMove.equals("Y")) {
                    return 2; //Paper
                } else if (yourMove.equals("Z")) {
                    return 3; // Scissor
                } else {
                    return 1;
                }
            case "C":
                if (yourMove.equals("Z")) {
                    return 1;  //Rock
                } else if (yourMove.equals("X")) {
                    return 2; // Paper
                } else {
                    return 3;
                }
            default:
                return 0;
        }
    }
}
