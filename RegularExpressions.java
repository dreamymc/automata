import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class RegularExpressions {

    public static boolean matchPatternRE(String input, String pattern) {
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(input);
        return matcher.matches();
    }

    public void run() {
        Scanner scan = new Scanner(System.in);
        System.out.print("\nEnter a Regular Expression (Use '|' instead of '+'): ");
        String re = scan.nextLine();
        System.out.print("Enter a string: ");
        String string = scan.nextLine();
        System.out.println("Regular expression: " + re);
        System.out.println("String: " + string);

        System.out.println(matchPatternRE(string, re) ? "The string is valid." : "The string is not valid.");
        scan.close();
    }

}
