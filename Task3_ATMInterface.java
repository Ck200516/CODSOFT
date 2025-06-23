import java.util.Scanner;

// Class representing a bank account
class BankAccount {
    private String accountHolderName;
    private double balance;

    public BankAccount(String accountHolderName, double initialBalance) {
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Please enter a valid amount to deposit.");
        } else {
            balance += amount;
            System.out.println("Amount of ₹" + amount + " deposited successfully.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Please enter a valid amount to withdraw.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance. Withdrawal failed.");
        } else {
            balance -= amount;
            System.out.println("Amount of ₹" + amount + " withdrawn successfully.");
        }
    }

    public void displayBalance() {
        System.out.printf("Current balance: ₹%.2f%n", balance);
    }
}

// Main ATM Interface class
public class Task3_ATMInterface {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the ATM Machine");
        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();

        System.out.print("Enter initial balance: ");
        double initialBalance = getValidDoubleInput();

        BankAccount userAccount = new BankAccount(name, initialBalance);

        int choice;
        do {
            System.out.println("\n========= ATM Menu =========");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");
            choice = getValidIntInput();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = getValidDoubleInput();
                    userAccount.withdraw(withdrawAmount);
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = getValidDoubleInput();
                    userAccount.deposit(depositAmount);
                    break;

                case 3:
                    userAccount.displayBalance();
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    // Helper method for valid integer input
    private static int getValidIntInput() {
        while (true) {
            try {
                String input = scanner.nextLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Enter a number: ");
            }
        }
    }

    // Helper method for valid double input
    private static double getValidDoubleInput() {
        while (true) {
            try {
                String input = scanner.nextLine();
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Enter a valid amount: ");
            }
        }
    }
}
