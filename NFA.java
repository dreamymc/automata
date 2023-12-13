import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class NFA {
    private Set<Integer> currentState; // Current state of the NFA

    // Define states
    private final Set<Integer> state0 = new HashSet<>(); // State 0
    private final Set<Integer> state1 = new HashSet<>(); // State 1
    private final Set<Integer> state2 = new HashSet<>(); // State 2

    // Define alphabet
    private final char[] alphabet = { '0', '1' }; // Alphabet of the NFA

    // Define transitions
    private final Set<Integer>[][] transitions = new HashSet[3][2]; // Transition function of the NFA

    // Define accepting state
    private final Set<Integer> acceptingState = new HashSet<>(); // Accepting state of the NFA

    public void run() {
        Scanner mikasa = new Scanner(System.in);
        print();
        System.out.print("Enter an input string: ");
        String input = mikasa.next();
        System.out.printf("Input '%s': " + (processInput(input) ? "Accepted" : "Rejected"), input);
        mikasa.close();
    }

    public void print() {
        System.out.println("Σ = {0, 1}");

        System.out.println("Transition:\nδ(q0, 0) = q1");
        System.out.println("δ(q0, 1) = q0");

        System.out.println("δ(q1, 0) = q2");
        System.out.println("δ(q1, 1) = q2");

        System.out.println("δ(q2, 0) = q2");
        System.out.println("δ(q2, 1) = q2");

        System.out.println("δ(q3, 0) = q2");
        System.out.println("δ(q3, 1) = q2");
    }

    public NFA() {
        // Initialize states
        state0.add(0);
        state1.add(1);
        state2.add(2);

        // Initialize transitions
        transitions[0][0] = state1; // Transition from state 0 on symbol '0'
        transitions[0][1] = state0; // Transition from state 0 on symbol '1'
        transitions[1][0] = state2; // Transition from state 1 on symbol '0'
        transitions[1][1] = state2; // Transition from state 1 on symbol '1'
        transitions[2][0] = state2; // Transition from state 2 on symbol '0'
        transitions[2][1] = state2; // Transition from state 2 on symbol '1'

        // Initialize accepting state
        acceptingState.add(2); // State 2 is an accepting state

        // Set initial state
        currentState = new HashSet<>();
        currentState.add(0); // The initial state is state 0
    }

    public boolean processInput(String input) {
        // Process each symbol in the input
        for (char symbol : input.toCharArray()) {
            Set<Integer> nextState = new HashSet<>(); // Next state of the NFA
            for (int currentState : this.currentState) {
                // Add all states reachable from the current state on the current symbol
                nextState.addAll(transitions[currentState][getSymbolIndex(symbol)]);
            }
            this.currentState = nextState; // Update the current state
        }

        // Check if the final state is an accepting state
        return !Collections.disjoint(currentState, acceptingState); // Return true if the final state is an accepting
                                                                    // state
    }

    private int getSymbolIndex(char symbol) {
        // Find the index of the symbol in the alphabet
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == symbol) {
                return i;
            }
        }
        return -1; // Symbol not found in the alphabet
    }
}