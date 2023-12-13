import java.util.Scanner;

public class MainClass {
    public static void main(String[] _dreamymc) {
        Scanner scan = new Scanner(System.in);
        System.out.print(
                "[1] Deterministic Finite Automata\n[2] Brute Force \n[3] Nondeterministic finite Automata \n[4] Turing Machine\n[5] Regular Expressions [6] Context Free Grammar\nChoose your program: ");
        String haha = scan.next();
        switch (haha) {
            case "1":
                new DFA().run();
                break;
            case "2":
                new BruteForcePassword().run();
                break;
            case "0":
                System.out.print("Program Closed.");
                System.exit(0);
                scan.close();
                break;
            case "3":
                new NFA().run();
                break;
            case "4":
                new TuringMachine().run();
                break;
            case "5":
                new RegularExpressions().run();
                break;
            case "6":
                new ContextFreeGrammar().run();
                break;
            default:
                System.out.println("Invalid Input.");
                break;
        }
    }
}
