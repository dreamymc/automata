import java.util.Scanner;

public class BruteForcePassword {
    public void run() {
        Scanner armin = new Scanner(System.in);
        System.out.print("Enter your password: "); // These section of the code is where the user inputs
        String targetPassword = armin.next(); // the password and try to crack it.
        long startTime = System.nanoTime(); //This specific line of code starts a variable for a timer to accumulate the elapsed
                                            //time of the program.
                                            
        // Define the characters to use in the brute force
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        int passwordLength = targetPassword.length();
        int attempts = 0;

        StringBuilder currentAttempt = new StringBuilder();

        // Start brute-force attack
        while (!currentAttempt.toString().equals(targetPassword)) {
            generateNextAttempt(currentAttempt, alphabet, passwordLength);
            attempts++;
        }

        // Print the result
        System.out.println("Password cracked: " + currentAttempt);
        System.out.println("Total attempts: " + attempts);

        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.println("Execution time in seconds: "
                + Long.valueOf(timeElapsed).doubleValue() / 1000000000 + "\n");
        armin.close();
    }

    // This section of the code tries to brute-force the given password and
    // increment the attempts it did.
    private void generateNextAttempt(StringBuilder currentAttempt, String alphabet, int passwordLength) {
        int base = alphabet.length();
        for (int i = 0; i < currentAttempt.length(); i++) {
            int index = alphabet.indexOf(currentAttempt.charAt(i));
            if (index < base - 1) {
                currentAttempt.setCharAt(i, alphabet.charAt(index + 1));
                return;
            } else {
                currentAttempt.setCharAt(i, alphabet.charAt(0));
            }
        }
        currentAttempt.append(alphabet.charAt(0));
    }
}
