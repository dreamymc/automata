import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TuringMachine {
    private static final char halt = '_';

    private Map<String, Map<Character, String[]>> transitions;

    private String currentState;
    private int headPosition;
    private StringBuilder tape;

    public TuringMachine(String input) {
        initializeTransitions();
        currentState = "q0";
        headPosition = 0;
        tape = new StringBuilder(input + halt); // Blank is added to the end of the tape
    }

    private void initializeTransitions() {
        transitions = new HashMap<>();

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

    public void run() {
        while (!currentState.equals("qA") && !currentState.equals("qR")) {
            char currentSymbol = tape.charAt(headPosition);
            String[] transition = transitions.get(currentState).get(currentSymbol);

            tape.setCharAt(headPosition, transition[1].charAt(0));
            headPosition += (transition[2].equals("R")) ? 1 : -1;
            currentState = transition[0];

            printCurrentState();
        }

        System.out.println(currentState.equals("qA") ? "Accepted" : "Rejected");
    }

    private void printCurrentState() {
        System.out.printf("State: %s, Tape: %s, Head Position: %d%n", currentState, tape, headPosition);
    }

    public static void main(String[] args) {
        System.out.print("Enter an input string: ");
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine(); // Change the input tape as needed
        TuringMachine turingMachine = new TuringMachine(input);
        turingMachine.run();
    }
}
