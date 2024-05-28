import java.util.Scanner;
class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    // Getter for account number
    String getAccountNumber() {
        return accountNumber;
    }

    // Getter for account holder name
    String getAccountHolderName() {
        return accountHolderName;
    }

    // Getter for balance
    double getBalance() {
        return balance;
    }

    // Method to update balance
    void updateBalance(double amount) {
        this.balance += amount;
    }
}

class Deposit {
    private BankAccount account;

    public Deposit(BankAccount account) {
        this.account = account;
    }

    void deposit(double amount) {
        if (amount > 0) {
            account.updateBalance(amount);
            System.out.println("Deposited: " + amount);
            System.out.println("Balance: " + account.getBalance());
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
}

class Withdraw {
    private BankAccount account;

    public Withdraw(BankAccount account) {
        this.account = account;
    }

    void withdraw(double amount) {
        if (amount > 0 && amount <= account.getBalance()) {
            account.updateBalance(-amount);
            System.out.println("Withdrew: " + amount);
            System.out.println("Balance: " + account.getBalance());
        } else if (amount > account.getBalance()) {
            System.out.println("Insufficient funds. Withdrawal failed.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }
}

public class Bank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creating a new bank account
        BankAccount account = new BankAccount("123456", "John Doe", 0.00);
        Deposit deposit = new Deposit(account);
        Withdraw withdraw = new Withdraw(account);

        System.out.println("Account created for " + account.getAccountHolderName() + " , Account info: " + account.getAccountNumber() +
                " with initial balance: " + account.getBalance());

        while (true) {
            System.out.println("Choose an option: ");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter amount to deposit: ");
                double depositAmount = scanner.nextDouble();
                deposit.deposit(depositAmount);
            } else if (choice == 2) {
                System.out.print("Enter amount to withdraw: ");
                double withdrawAmount = scanner.nextDouble();
                withdraw.withdraw(withdrawAmount);
            } else if (choice == 3) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}