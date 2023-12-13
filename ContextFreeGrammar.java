import java.util.HashMap;
import java.util.Scanner;

public class ContextFreeGrammar {

    private static String inputString;
    private static int currentIndex;

    public void run() {
        Scanner scan = new Scanner(System.in);
        String[] inputStringChar;
        HashMap<String, String> hm = new HashMap<>();
        hm.put("a", "a");
        hm.put("b", "b");
        hm.put("c", "c");
        System.out.println("G = { {a, b, c}, {S}, {S → aSa | bSb | c}, {S} }");

        System.out.print("Enter an input string: ");
        inputString = scan.nextLine();
        inputStringChar = inputString.split("");
        for (String character : inputStringChar) {
            if (!hm.containsKey(character))
                System.out.println(
                        "Consider that the input string only contains the terminal symbols from the grammar.\n");
        }
        currentIndex = 0;
        if (isValid())
            System.out.println("Input string is valid according to the grammar.\n");
        else
            System.out.println("Input string is not valid according to the grammar.\n");
        scan.close();
    }

    private static boolean isValid() {
        return S() && currentIndex == inputString.length();
    }

    private static boolean S() {
        if (currentIndex < inputString.length()) {
            char currentChar = inputString.charAt(currentIndex);

            switch (currentChar) {
                case 'a':
                    currentIndex++;
                    if (S() && match('a')) {
                        return true;
                    }
                    break;
                case 'b':
                    currentIndex++;
                    if (S() && match('b')) {
                        return true;
                    }
                    break;
                case 'c':
                    currentIndex++;
                    return true;
                default:
                    return false;
            }
        }

        return false;
    }

    private static boolean match(char expected) {
        if (currentIndex < inputString.length() && inputString.charAt(currentIndex) == expected) {
            currentIndex++;
            return true;
        }
        return false;
    }
}
