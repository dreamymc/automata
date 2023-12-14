import java.util.*;

public class PushDownAutomata {

    // This method is the entry point of the program
    public void run() {
        // Create a new Scanner object for reading the input
        Scanner scan = new Scanner(System.in);
        System.out.println("Push Down Automata\n");
        System.out.print("Enter the input string: ");

        // Read the input string from the user
        String input = scan.nextLine();

        // Close the scanner object after use
        scan.close();

        // Call the verifyPDA method with the input string and print the result
        System.out.println(verifyPDA(input) ? "Accepted" : "Rejected");
    }

    // This method verifies if the input string is accepted by the Push Down
    // Automata
    private static boolean verifyPDA(String input) {
        // Create a new Stack object
        Stack<Character> stack = new Stack<>();
        // Initialize the stack with 'Z'
        stack.push('Z');

        // Initialize the current state to "q1"
        String currentState = "q1";

        // Loop through each character in the input string
        for (int i = 1; i <= input.length(); i++) {
            // Get the current symbol
            char symbol = input.charAt(i - 1);

            // Print the current step, symbol, and state
            System.out.println("\nStep " + i + ":");
            System.out.println("Symbol: " + symbol);
            System.out.println("State: " + currentState);

            // Switch statement for the current state
            switch (currentState) {
                case "q1":
                    // If the symbol is '0' and the top of the stack is 'Z'
                    if (symbol == '0' && !stack.isEmpty() && stack.peek() == 'Z') {
                        // Push the symbol onto the stack
                        stack.push(symbol);
                        // Change the current state to "q2"
                        currentState = "q2";
                        System.out.println("Action: Push " + symbol + " onto the stack");
                    }
                    // If the symbol is '1' and the top of the stack is 'Z'
                    else if (symbol == '1' && !stack.isEmpty() && stack.peek() == 'Z')
                        // Change the current state to "q3"
                        currentState = "q3";
                    else
                        // If none of the conditions are met, reject the input
                        return false;

                    break;

                case "q2":
                    // If the symbol is '0'
                    if (symbol == '0') {
                        // Push the symbol onto the stack
                        stack.push(symbol);
                        System.out.println("Action: Push " + symbol + " onto the stack");
                    }
                    // If the symbol is '1' and the top of the stack is '0'
                    else if (symbol == '1' && !stack.isEmpty() && stack.peek() == '0') {
                        // Pop the top of the stack
                        stack.pop();
                        System.out.println("Action: Pop a '0' from the stack");
                    } else
                        // If none of the conditions are met, reject the input
                        return false;

                    break;

                case "q3":
                    // If the symbol is '1' and the top of the stack is '0'
                    if (symbol == '1' && !stack.isEmpty() && stack.peek() == '0') {
                        // Pop the top of the stack
                        stack.pop();
                        System.out.println("Action: Pop a '0' from the stack");
                    } else {
                        // If none of the conditions are met, reject the input
                        return false;
                    }
                    break;
            }

            // Print the current stack
            System.out.println("Stack: " + stack);
        }

        // If the current state is "q2" or "q3" and the stack contains only 'Z'
        if ((currentState.equals("q2") || currentState.equals("q3")) && stack.size() == 1 && stack.peek() == 'Z') {
            // Change the current state to "q4"
            currentState = "q4";
            System.out.println("Final State: " + currentState);
            // Accept the input
            return true;
        } else {
            // If none of the conditions are met, reject the input
            return false;
        }
    }
}
