import java.util.*;

// Define the class ContextFreeGrammar
public class ContextFreeGrammar {

    // Define the input string and the current index
    private static String inputString;
    private static int currentIndex;

    // Method to run the Context Free Grammar
    public void run() {
        // Create a Scanner object for reading the input
        Scanner annie = new Scanner(System.in);
        // Initialize an array to store the characters of the input string
        String[] inputStringChar;
        // Initialize a HashMap to store the terminal symbols of the grammar
        HashMap<String, String> hm = new HashMap<>();
        hm.put("a", "a");
        hm.put("b", "b");
        hm.put("c", "c");
        // Print the grammar
        System.out.println("G = { {a, b, c}, {S}, {S → aSa | bSb | c}, {S} }");

        // Prompt the user to enter an input string
        System.out.print("Enter an input string: ");
        // Read the input string
        inputString = annie.nextLine();
        // Split the input string into characters
        inputStringChar = inputString.split("");
        // For each character in the input string
        for (String character : inputStringChar) {
            // If the character is not a terminal symbol of the grammar
            if (!hm.containsKey(character))
                // Print a message to the user
                System.out.println(
                        "Consider that the input string only contains the terminal symbols from the grammar.\n");
        }
        // Initialize the current index
        currentIndex = 0;
        // If the input string is valid according to the grammar
        if (isValid()) {
            // Print a message to the user
            System.out.println("Input string is valid according to the grammar.\n");
        } else {
            // Print a message to the user
            System.out.println("Input string is not valid according to the grammar.\n");
        }
        // Close the scanner
        annie.close();
    }

    // Method to check if the input string is valid according to the grammar
    private static boolean isValid() {
        // Return true if the input string is accepted by the grammar and all characters
        // of the input string are consumed
        return S() && currentIndex == inputString.length();
    }

    // Method to process the non-terminal symbol S
    private static boolean S() {
        // If there are more characters in the input string
        if (currentIndex < inputString.length()) {
            // Get the current character
            char currentChar = inputString.charAt(currentIndex);

            // Switch case based on the current character
            switch (currentChar) {
                case 'a':
                    // Move to the next character
                    currentIndex++;
                    // If the rest of the input string is accepted by the grammar and the next
                    // character is 'a'
                    if (S() && match('a')) {
                        // Return true
                        return true;
                    }
                    break;
                case 'b':
                    // Move to the next character
                    currentIndex++;
                    // If the rest of the input string is accepted by the grammar and the next
                    // character is 'b'
                    if (S() && match('b')) {
                        // Return true
                        return true;
                    }
                    break;
                case 'c':
                    // Move to the next character
                    currentIndex++;
                    // Return true
                    return true;
                default:
                    // Return false
                    return false;
            }
        }

        // Return false
        return false;
    }

    // Method to check if the next character matches the expected character
    private static boolean match(char expected) {
        // If there are more characters in the input string
        if (currentIndex < inputString.length() && inputString.charAt(currentIndex) == expected) {
            // Return true without moving to the next character
            return true;
        }
        // Return false
        return false;
    }

}