public class CurrentAccount extends Account {
        private double overdraftLimit;

        public CurrentAccount(String accountNumber, String accountHolderName, double initialBalance, double overdraftLimit) {
            super(accountNumber, accountHolderName, initialBalance);
            this.overdraftLimit = overdraftLimit;
        }

        @Override
        public void withdraw(double amount) {
            if (amount > 0 && amount <= getBalance() + overdraftLimit) {
                double newBalance = getBalance() - amount;
                if (newBalance < 0) {
                    overdraftLimit += newBalance; // Adjust the overdraft limit
                    newBalance = 0;
                }
                super.deposit(-amount); // Using negative amount to reduce balance
                System.out.println("Withdrew: " + amount);
            } else {
                System.out.println("Invalid withdraw amount or overdraft limit exceeded");
            }
        }

        @Override
        public void calculateInterest() {
            // Typically, current accounts do not have interest calculation
            System.out.println("No interest calculation for current account");
        }

        // Additional methods specific to CurrentAccount can be added here
    }

