import java.util.Scanner;

// Bank Account class
class BankAccount {
    private String accountHolder;
    private double balance;

    public BankAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("✅ Deposit successful!");
        } else {
            System.out.println("❌ Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("✅ Withdrawal successful!");
        } else if (amount > balance) {
            System.out.println("❌ Insufficient funds.");
        } else {
            System.out.println("❌ Invalid withdrawal amount.");
        }
    }

    public String getAccountHolder() {
        return accountHolder;
    }
}

// ATM class
public class ATMInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a sample user account
        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();
        BankAccount userAccount = new BankAccount(name, 1000); // default ₹1000

        int choice;

        do {
            System.out.println("\n===== ATM Menu =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Balance: ₹" + userAccount.getBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ₹");
                    double depositAmount = scanner.nextDouble();
                    userAccount.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdrawAmount = scanner.nextDouble();
                    userAccount.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("👋 Thank you for using the ATM.");
                    break;
                default:
                    System.out.println("❌ Invalid option. Please choose again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
