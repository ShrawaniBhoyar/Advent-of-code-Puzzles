import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.Collections;

public class Assignment5b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       // System.out.println("Enter the starting stacks of crates:");

        // Read input lines until an empty line is encountered
        List<Stack<Character>> stacks = readStartingStacks(scanner);
        //printAllStacks(stacks);
        //List<Stack<Character>> reversedStacks = reverseStack(stacks);
        //printAllStacks(reversedstacks);
        reverseStacksElements(stacks);
        //printAllStacks(stacks);
        // System.out.println("Enter the rearrangement procedure:");

        // Read and perform the rearrangement procedure
        while (scanner.hasNextLine()) {
            String move = scanner.nextLine().trim();
            if (move.isEmpty()) {
            continue;
            }
            performMove(stacks, move);
        }

        // Print the result
        String concatenatedResult = concatenateTopCrates(stacks);
    System.out.println(concatenatedResult);
    }

    private static List<Stack<Character>> readStartingStacks(Scanner scanner) {
    List<Stack<Character>> stacks = new ArrayList<>();
    
    // Read all lines and initialize each stack with an empty character
    while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        if (line.isEmpty() || line.matches("[\\d\\s]+")) {
            break;
        }

        // Iterate through each character in the line and populate the stacks
        
        for (int i = 0; i < line.length(); i++) {
            char crate = line.charAt(i);

            // Skip '[' and ']' characters
            if (crate == '[' || crate == ']' || crate == ' ') {
                continue;
            }

            // Ensure there are enough stacks in the list for the current column
            int stackIndex = i / 4;  // Assuming each stack has 4 columns
            while (stacks.size() <= stackIndex) {
                stacks.add(new Stack<>());
            }

            // Push the crate onto the corresponding stack
            stacks.get(stackIndex).push(crate);
        }
    }
    return stacks;
    }
    
    //private static void printAllStacks(List<Stack<Character>> stacks) {
    //for (int i = 0; i < stacks.size(); i++) {
     //   Stack<Character> stack = stacks.get(i);
     //   System.out.print("Stack " + (i + 1) + ": [");

        // Print each crate in the stack
      //  for (Character crate : stack) {
    //        System.out.print(crate + " ");
     //   }

    //    System.out.println("]");
    //}
    //}
    
    private static void reverseStacksElements(List<Stack<Character>> stacks) {
        for (Stack<Character> stack : stacks) {
            List<Character> elementsList = Collections.list(stack.elements());
            Collections.reverse(elementsList);
            stack.clear();
            for (Character element : elementsList) {
                stack.push(element);
            }
        }
    }
    
    private static void performMove(List<Stack<Character>> stacks, String move) {
    String[] parts = move.split(" ");
    int fromStack = Integer.parseInt(parts[3])-1;
    int toStack = Integer.parseInt(parts[5])-1;
    int count = Integer.parseInt(parts[1]);
    //System.out.println("Performing move: " + move); // Debug statement

    
    if (fromStack >= 0 && fromStack < stacks.size() && toStack >= 0 && toStack < stacks.size()) {
        if (!stacks.get(fromStack).isEmpty()) {
        Stack<Character> tempStack = new Stack<>();    
            for (int i = 0; i < count; i++) {
                if (!stacks.get(fromStack).isEmpty()) {
                    char crate = stacks.get(fromStack).pop();
                    tempStack.push(crate);
                }  else {
                    System.out.println("Source stack is empty. Unable to move crates.");
                    break;
                }
            }
            while (!tempStack.isEmpty()) {
                    char crate = tempStack.pop();
                    stacks.get(toStack).push(crate);
                }
        } else {
            System.out.println("Source stack is empty. Unable to move crates.");
        } 
        
    }else {
        System.out.println("Invalid stack indices. Unable to move crates.");
    }
    //printAllStacks(stacks); // Debug statement to print updated stacks
    }
    
    private static String concatenateTopCrates(List<Stack<Character>> stacks) {
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < stacks.size(); i++) {
        char topCrate = stacks.get(i).isEmpty() ? ' ' : stacks.get(i).peek();
        result.append(topCrate);
    }

    return result.toString();
    }
    
}






