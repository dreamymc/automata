// [1] Add production rule 
// [2] Verify 
// [3] Restart 
// [4] Exit 
// Choose: 
// Handles user input and updates production rules accordingly
import java.util.*;

public class GreibachNormalForm {

    public void run() {
        Scanner scan = new Scanner(System.in);
        Map<String, List<String>> map = new HashMap<>();
        String startSymbol = "";
        boolean flag;

        while (true)
            try {
                System.out.print("[1] Add production rule \n[2] Verify \n[3] Restart \n[4] Exit \nChoose: ");
                int choice = Integer.parseInt(scan.nextLine());
                System.out.println();

                switch (choice) {
                    case 1:
                        // Adds production rules based on user input
                        do {
                            flag = false;
                            System.out.print("Enter a non-terminal symbol: ");
                            String nTerm = scan.nextLine();
                            char nTermChar = nTerm.charAt(0);

                            if (nTerm.length() == 1 && Character.isUpperCase(nTermChar)) {
                                if (startSymbol == null)
                                    startSymbol = nTerm; // Set the start symbol to the first non-terminal symbol

                                System.out.printf(
                                        "Enter the Right-hand Side (No space; Separated by '|'; Underscore '_' for epsilon): \n%s --> ",
                                        nTerm);
                                String pRules = scan.nextLine();
                                List<String> rules = new ArrayList<>();
                                if (map.containsKey(nTerm))
                                    rules.addAll(map.get(nTerm));

                                rules.addAll(Arrays.asList(pRules.split("\\|")));
                                map.put(nTerm, rules);
                                System.out.println("\nDisplaying all production rules:");
                                for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                                    System.out.println(entry.getKey() + " --> " + String.join(" | ", entry.getValue()));
                                }
                                System.out.println();
                                break;
                            } else {
                                System.out.println(nTerm
                                        + " is an invalid terminal. Please use one non-terminal for each production rule.\n");
                                System.out.print("re-");
                                flag = true;
                            }
                        } while (flag);
                        break;
                    case 2:
                        // Verifies if the given production rules follow Greibach Normal Form (GNF)
                        boolean verify = true;
                        for (List<String> list : map.values())
                            if (!verifyGNF(list))
                                verify = false;
                        System.out.println(verify ? "Accepted" : "Rejected");
                        break;
                    case 3:
                        // Restarts the program by clearing production rules
                        System.out.println("Program restarted.\n");
                        map.clear();
                        break;
                    case 4:
                        // Exits the program
                        System.out.println("Program closed.");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid. Re-run the program.\n");
                break;
            } catch (NumberFormatException f) {
                System.out.println("\nInvalid. Re-run the program.\n");
                break;
            }
        scan.close();
    }

    // Verifies if the given production rules follow GNF
    public boolean verifyGNF(List<String> productionRules) {
        boolean flag = true;

        for (String productionRule : productionRules) {
            int prLength = productionRule.length();

            if (prLength > 1 && Character.isLowerCase(productionRule.charAt(0))
                    && productionRule.substring(1).toUpperCase().equals(productionRule.substring(1))) {
                System.out.println("Right hand-side '" + productionRule + "' passed.");
            } else if (prLength == 1 && Character.isLowerCase(productionRule.charAt(0))) {
                System.out.println("Right hand-side '" + productionRule + "' passed.");
            } else if (prLength == 1 && productionRule.equals("_")) {
                System.out.println("Epsilon " + productionRule + " breaks one of the rules of GNF.");
                flag = false;
            } else if (prLength == 1 && Character.isUpperCase(productionRule.charAt(0))) {
                System.out.println("Right hand-side '" + productionRule + "' did not pass (Unit production).");
                flag = false;
            }
        }
        return flag;
    }
}
