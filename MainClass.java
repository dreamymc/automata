import java.util.Scanner;

public class MainClass {
    static void print() {
        System.out.println("[1] Deterministic Finite Automata");
        System.out.println("[2] Brute Force Password");
        System.out.println("[3] Nondeterministic Finite Automata");
        System.out.println("[4] Turing Machine");
        System.out.println("[5] Regular Expressions");
        System.out.println("[6] Context Free Grammar");
        System.out.println("[7] Tower of Hanoi");
        System.out.println("[8] Push Down Automata");
        System.out.println("[9] Greibach Normal Form");
        System.out.println("[10] Chomsky Normal Form");
        System.out.println("[11] Traveling Salesperson");

        System.out.print("Choose a program: ");
    }

    public static void main(String[] _dreamymc) {
        Scanner scan = new Scanner(System.in);

            print();
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
                case "7":
                    towerOfHanoi tower = new towerOfHanoi();
                    // initializing the towers
                    tower.Pole1.push(tower.largeDisk);
                    tower.Pole1.push(tower.mediumDisk);
                    tower.Pole1.push(tower.smallDisk);
                    tower.print();
                    tower.run();
                    break;
                case "8":
                    new PushDownAutomata().run();
                    break;
                case "9":
                    new GreibachNormalForm().run();
                    break;
                case "10":
                    new ChomskyNormalForm().run();
                    break;
                case "11":
                    new TravelingSalesmanProblem().run();
                    break;
                default:
                    System.out.println("Invalid Input.");
                    break;
            }
        }
    }

