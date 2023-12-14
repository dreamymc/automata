
import java.util.*;

// Define the class TuringMachine
public class TuringMachine {
    // Define the halt character
    private static final char halt = '_';

    // Define the transitions map
    private Map<String, Map<Character, String[]>> transitions;

    // Define the current state, head position, and tape
    private String currentState;
    private int headPosition;
    private StringBuilder tape;

    // Method to define the transitions
    private void transitions() {
        // Initialize the transitions map
        transitions = new HashMap<>();
        // Define the transitions for each state
        transitions.put("q0", Map.of(
                '0', new String[] { "q1", "x", "R" },
                '1', new String[] { "qR", "1", "R" },
                halt, new String[] { "qR", halt + "", "R" }));

        transitions.put("q1", Map.of(
                '0', new String[] { "q2", "x", "R" },
                '1', new String[] { "q1", "y", "R" },
                halt, new String[] { "qR", halt + "", "R" }));

        transitions.put("q2", Map.of(
                '0', new String[] { "qR", "0", "R" },
                '1', new String[] { "qR", "1", "R" },
                halt, new String[] { "qA", halt + "", "R" }));
    }

    // Method to run the Turing machine
    public void run() {
        // Prompt the user to enter an input string
        System.out.print("Enter an input string: ");
        // Create a Scanner object for reading the input
        Scanner sasha = new Scanner(System.in);
        // Read the input string
        String input = sasha.nextLine();
        // Define the transitions
        transitions();
        // Initialize the current state, head position, and tape
        currentState = "q0";
        headPosition = 0;
        tape = new StringBuilder(input + halt);
        // While the current state is not "qA" or "qR"
        while (!currentState.equals("qA") && !currentState.equals("qR")) {
            // Get the current symbol
            char currentSymbol = tape.charAt(headPosition);
            // Get the transition for the current state and symbol
            String[] transition = transitions.get(currentState).get(currentSymbol);

            // Update the tape, head position, and current state
            tape.setCharAt(headPosition, transition[1].charAt(0));
            headPosition += (transition[2].equals("R")) ? 1 : -1;
            currentState = transition[0];

            // Print the current state, tape, and head position
            printStates();
        }

        // Print whether the input string was accepted or rejected
        System.out.println(currentState.equals("qA") ? "Accepted" : "Rejected");
        // Close the scanner
        sasha.close();
    }

    // Method to print the current state, tape, and head position
    private void printStates() {
        System.out.printf("State: %s, Tape: %s, Head Position: %d%n", currentState, tape, headPosition);
    }

}