import java.util.Scanner;

public class BankingProgram {
    static Scanner scanner = new Scanner(System.in);

    // ANSI color codes
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";

    public static void main(String[] args) {
        double balance = 0;
        boolean isRunning = true;
        int choice;

        System.out.println(CYAN + "********************" + RESET);
        System.out.println(YELLOW + "     BANKING PROGRAM" + RESET);

        while (isRunning) {
            System.out.println(CYAN + "********************" + RESET);
            System.out.println("1. Show Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.println(CYAN + "********************" + RESET);

            System.out.print(GREEN + "Enter your choice: " + RESET);
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> showBalance(balance);
                case 2 -> balance += deposit();
                case 3 -> balance -= withdraw(balance);
                case 4 -> isRunning = false;
                default -> System.out.println(RED + "Invalid Choice!" + RESET);
            }
        }

        System.out.println(PURPLE + "-------------------" + RESET);
        System.out.println(PURPLE + "Exiting............" + RESET);
        System.out.println(PURPLE + "Thank you! Goodbye!" + RESET);
        System.out.println(PURPLE + "-------------------" + RESET);

        scanner.close();
    }

    static void showBalance(double balance) {
        System.out.println(BLUE + "--------------------" + RESET);
        System.out.printf(BLUE + "$%.2f\n" + RESET, balance);
        System.out.println(BLUE + "--------------------" + RESET);
    }

    static double deposit() {
        double amount;

        System.out.print(GREEN + "Enter Deposit Amount: " + RESET);
        amount = scanner.nextDouble();

        if (amount < 0) {
            System.out.println(RED + "-------------------" + RESET);
            System.out.println(RED + "Amount can't be less than 0" + RESET);
            return 0;
        } else {
            return amount;
        }
    }

    static double withdraw(double balance) {
        double amount;

        System.out.print(GREEN + "Enter Withdraw Amount: " + RESET);
        amount = scanner.nextDouble();

        if (amount > balance) {
            System.out.println(RED + "-------------------" + RESET);
            System.out.println(RED + "Insufficient balance!" + RESET);
            return 0;
        } else if (amount < 0) {
            System.out.println(RED + "-------------------" + RESET);
            System.out.println(RED + "Amount can't be negative!" + RESET);
            return 0;
        } else {
            return amount;
        }
    }
}
