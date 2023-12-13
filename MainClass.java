import java.util.Scanner;

public class MainClass {
    public static void main(String[] _dreamymc) {
        Scanner scan = new Scanner(System.in);
        DFA dfa = new DFA();
        BruteForcePassword brute = new BruteForcePassword();
        NFA nfa = new NFA();
        System.out.print(
                "[1] Deterministic Finite Automata\n[2] Brute Force \n[3] Nondeterministic finite Automata \nChoose your program: ");
        String haha = scan.next();
        switch (haha) {
            case "1":
                dfa.run();
                break;
            case "2":
                brute.run();
                break;
            case "0":
                System.out.print("Program Closed.");
                System.exit(0);
                scan.close();
                break;
            case "3":
                nfa.run();
                break;
                case "4": 
                break;
            default:
                System.out.println("Invalid Input.");
                break;
        }
    }
}
