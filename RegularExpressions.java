import java.util.regex.*;
import java.util.Scanner;

// Define the class RegularExpressions
public class RegularExpressions {

    // Method to match a string with a given regular expression pattern
    public static boolean matchPatternRE(String input, String pattern) {
        // Compile the regular expression pattern
        Pattern regex = Pattern.compile(pattern);
        // Create a matcher that will match the given input against this pattern
        Matcher matcher = regex.matcher(input);
        // Return true if the entire region sequence matches the matcher's pattern
        return matcher.matches();
    }

    // Method to run the regular expression matching
    public void run() {
        // Create a Scanner object for reading the input
        Scanner reiner = new Scanner(System.in);
        // Prompt the user to enter a regular expression
        System.out.print("\nEnter a Regular Expression (Use '|' instead of '+'): ");
        // Read the regular expression from the user
        String re = reiner.nextLine();
        // Prompt the user to enter a string
        System.out.print("Enter a string: ");
        // Read the string from the user
        String string = reiner.nextLine();
        // Print the regular expression
        System.out.println("Regular expression: " + re);
        // Print the string
        System.out.println("String: " + string);

        // Print whether the string matches the regular expression
        System.out.println(matchPatternRE(string, re) ? "The string is valid." : "The string is not valid.");
        // Close the scanner object
        reiner.close();
    }

}