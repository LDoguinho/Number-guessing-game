import java.util.Scanner;

public class GameConf {
    public static final Scanner scanner = new Scanner(System.in);
    public static final int minNum = 0;
    public static final int maxNum = 100;
    public static int attempts = 0;
    public static int Num;
    public static int currentAttempts = 0;

    public static int Randomizer() {

        return (int) Math.floor(Math.random() * (maxNum - minNum + 1) + minNum);
    }

    public static void ChoseDificulty() {
        int Dnum = scanner.nextInt();
        
        switch (Dnum) {
            case 1:
                System.out.println("You chosed Easy difficulty");
                attempts = 10;
                System.out.println("Press 1 to start!");
                System.out.println("----------------------------------------------------");
                StartG();
                break;
            case 2:
                System.out.println("You chosed Medium difficulty");
                attempts = 5;
                System.out.println("Press 1 to start!");
                System.out.println("----------------------------------------------------");
                StartG();
                break;
            case 3:
                System.out.println("You chosed Hard difficulty");
                attempts = 3;
                System.out.println("Press 1 to start!");
                System.out.println("----------------------------------------------------");
                StartG();
                break;
            default:
                System.out.println("Error! Chose a option");
                ChoseDificulty();
                break;
        }
        scanner.close();
    }

    public static void StartG() {
        Num = Randomizer();

        int start = scanner.nextInt();
        switch (start) {
            case 1:
                System.out.println("Try guess the number!");
                Guess();
                break;

            default:
                System.out.println("Error! Chose the correct option");
                StartG();
                break;
        }
        scanner.close();
    }

    public static void Guess() {
        ++currentAttempts;
        if (currentAttempts <= attempts) {
            int guessNum = scanner.nextInt();

            if (guessNum == Num) {
                System.out.println("Congratulations, your answer is correct!!!");
                Guess();

            } else if (guessNum < Num) {
                System.out.println("The secret number is great that " +guessNum);
                Guess();

            } else {
                System.out.println("The secret number is lower that " +guessNum);
                Guess();
            }

            scanner.close();
        } else {
            System.out.println("----------------------------------------------------");
            System.out.println("You already used all of your attempts");
            System.out.println("The secret number was: "+Num);
        }
    }
}
