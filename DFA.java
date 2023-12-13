import java.util.Scanner;

public class DFA {
    public void print() {
        System.out.println("Σ = {0, 1}");

        System.out.println("Transition:\nδ(q0, 0) = q1");
        System.out.println("δ(q0, 1) = q2");

        System.out.println("δ(q1, 0) = q1");
        System.out.println("δ(q1, 1) = q3");

        System.out.println("δ(q2, 0) = q1");
        System.out.println("δ(q2, 1) = q2");

        System.out.println("δ(q3, 0) = q1");
        System.out.println("δ(q3, 1) = q4");
    }

    public void run() {
        // Pre defined dfa diagram
        // Example DFA transitions:
        int[][] transitions = {
                { 1, 2 }, // State 0 transitions on input 0 to state 1, on input 1 to state 2
                { 1, 3 }, // State 1 transitions on input 0 to state 1, on input 1 to state 3
                { 1, 2 }, // State 2 transitions on input 0 to state 1, on input 1 to state 2
                { 1, 4 } // State 3 transitions on input 0 to state 1, on input 1 to state 4
        };
        int currentState = 0; // Initial state
        // Use Scanner to take input string
        print();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter input string: ");
        String input = scanner.next();

        // Process each character in the input string
        for (char c : input.toCharArray()) {
            int inputSymbol = Character.getNumericValue(c);
            currentState = transitions[currentState][inputSymbol];
        }

        // Check if the final state is an accepting state and display the result
        System.out.println("Input string is " + (currentState == 4 ? "accepted" : "rejected"));

        // Close the scanner
        scanner.close();
    }
}
