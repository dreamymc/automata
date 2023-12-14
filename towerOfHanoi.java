import java.util.Scanner;
import java.util.Stack;

public class towerOfHanoi {
    // this section of the code initiates the poles and the disk
    Scanner scan = new Scanner(System.in);
    Stack<String> Pole1 = new Stack<>();
    Stack<String> Pole2 = new Stack<>();
    Stack<String> Pole3 = new Stack<>();
    String largeDisk = "Large Disk";
    String mediumDisk = "Medium Disk";
    String smallDisk = "Small Disk";

    // these section of the code will be the one to put actions to the methods
    public void oneToTwo() {
        Pole2.push(Pole1.pop());
    }

    public void twoToOne() {
        Pole1.push(Pole2.pop());
    }

    public void oneToThree() {
        Pole3.push(Pole1.pop());
    }

    public void threeToOne() {
        Pole1.push(Pole3.pop());
    }

    public void threeToTwo() {
        Pole2.push(Pole3.pop());
    }

    public void twoToThree() {
        Pole3.push(Pole2.pop());
    }

    // this variable will count how many tries the user had to complete the tower of
    // hanoi
    int tries = 0;

    /*
     * this section of the code is where the user input is drastically being used
     * this section of the code already accounted the possible errors the user might
     * encounter upon solving the tower of hanoi
     */
    public void run() {
        try {
            while (true) {
                if (!Pole3.isEmpty() && Pole3.size() == 3 & Pole3.get(0) == largeDisk && Pole3.get(1) == mediumDisk
                        && Pole3.get(2) == smallDisk) {
                    System.out.println("Congratulations you won!");
                    System.out.printf("You moved %d times", tries);
                    break;
                } else {
                    System.out.print("Press [1] to move from tower 1 to 2\n"
                            + "Press [2] to move from tower 2 to 1\n"
                            + "Press [3] to move from tower 1 to 3\n"
                            + "Press [4] to move from tower 3 to 1\n"
                            + "Press [5] to move from tower 3 to 2\n"
                            + "Press [6] to move from tower 2 to 3\nEnter: ");
                    int choice = scan.nextInt();
                    tries++;
                    switch (choice) {
                        case 1:
                            oneToTwo();
                            break;
                        case 2:
                            twoToOne();
                            break;
                        case 3:
                            oneToThree();
                            break;
                        case 4:
                            threeToOne();
                            break;
                        case 5:
                            threeToTwo();
                            break;
                        case 6:
                            twoToThree();
                            break;
                        default:
                            System.out.println("\033[0;1m" + "Invalid Input." + "\u001B[0m");
                    }
                    print();
                }
            }
        } catch (java.util.EmptyStackException error) {
            System.err.println("\033[0;1m" + "That pole is empty!" + "\u001B[0m");
            print();
            run();
        } catch (java.util.InputMismatchException e) {
            System.err.println("\033[0;1m" + "Only use the given choices to move! " + "\u001B[0m");
            print();
            run();
        }
    }

    public void print() {
        System.out.println("Tower 1: " + Pole1);
        System.out.println("Tower 2: " + Pole2);
        System.out.println("Tower 3: " + Pole3);
        System.out.println("\n");
    }
}
