import java.util.*;

public class ChomskyNormalForm {

	public void run() {
		Scanner scan = new Scanner(System.in);
		Map<String, List<String>> map = new HashMap<>();
		String startSymbol = null;
		boolean flag;
		System.out.println("Chomsky Normal Form\n");

		while (true)
			try {

				System.out.print("[1] Add production rule \n[2] Verify \n[3] Restart \n[4] Exit \nChoose: ");
				int choice = Integer.parseInt(scan.nextLine());
				System.out.println();
				switch (choice) {
					case 1:
						do {
							flag = false;
							System.out.print("Enter a non-terminal symbol: ");
							String nTerm = scan.nextLine();
							char nTermChar = nTerm.charAt(0);

							if (nTerm.length() == 1 && Character.isUpperCase(nTermChar)) {
								if (startSymbol == null) {
									startSymbol = nTerm; // Set the start symbol to the first non-terminal symbol
								}

								System.out.printf(
										"Enter the Right-hand Side (No space; Separated by '|'; Underscore '_' for epsilon): \n%s --> ",
										nTerm);

								String pRules = scan.nextLine();
								List<String> rules = new ArrayList<>();

								if (map.containsKey(nTerm)) {
									rules.addAll(map.get(nTerm));
								}

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
						boolean verify = true;
						for (List<String> list : map.values()) {
							if (!verifyCNF(list)) {
								verify = false;
							}
						}

						if (verify) {
							System.out.println("\nThe grammar is considered as Context Free Grammar.\n");
						} else {
							System.out.println("\nThe grammar is not considered as Context Free Grammar.\n");
						}
						break;

					case 3:
						System.out.println("Program restarted.\n");
						map.clear();
						break;
					case 4:
						System.out.println("Program closed.");
						System.exit(0);
						break;
					default:
						System.out.println("Invalid choice.");
						break;
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid input. Please re-run the program.\n");
				break;
			} catch (NumberFormatException f) {
				System.out.println("\nInvalid input. Please re-run the program.\n");
				break;
			}
		scan.close();

	}

	public static boolean verifyCNF(List<String> productionRules) {
		boolean verify = true;
		for (String productionRule : productionRules) {

			int prLength = productionRule.length();

			if (prLength > 2 && prLength < 0) {
				System.out.println("RHS " + productionRule + " did not pass.");
				verify = false;
				return verify;
			} else {

				if (prLength == 1 && Character.isUpperCase(productionRule.charAt(0))) {
					System.out.println("RHS '" + productionRule + "' did not pass (Unit production).");
					verify = false;
				} else if (prLength == 1 && Character.isLowerCase(productionRule.charAt(0))) {
					System.out.println("RHS '" + productionRule + "' passed.");
				} else if (prLength == 2 && Character.isUpperCase(productionRule.charAt(0))
						&& Character.isUpperCase(productionRule.charAt(1))) {
					System.out.println("RHS '" + productionRule + "' passed.");
				} else if (prLength == 1 && productionRule.equals("_")) {
					System.out.println("Epsilon '" + productionRule + "' breaks the one of the rules of CNF.");
					verify = false;
				}

			}

		}
		return verify;
	}

}
