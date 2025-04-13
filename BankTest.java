public class BankTest {

    // Custom Exception: InvalidDepositException
    static class InvalidDepositException extends Exception {
        public InvalidDepositException() {
            super("Deposit amount must be greater than zero.");
        }

        public InvalidDepositException(String message) {
            super(message);
        }
    }

    // Custom Exception: InsufficientFundsException
    static class InsufficientFundsException extends Exception {
        public InsufficientFundsException() {
            super("Insufficient funds available.");
        }

        public InsufficientFundsException(String message) {
            super(message);
        }
    }

    // BankAccount class
    static class BankAccount {
        private String accountNumber;
        private double balance;

        public BankAccount() {
            this.accountNumber = "0000";
            this.balance = 0.0;
        }

        public BankAccount(String accountNumber, double balance) {
            this.accountNumber = accountNumber;
            this.balance = balance;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public void setAccountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        public void deposit(double amount) throws InvalidDepositException {
            if (amount <= 0) {
                throw new InvalidDepositException();
            }
            balance += amount;
        }

        public void withdraw(double amount) throws InsufficientFundsException {
            if (amount > balance) {
                throw new InsufficientFundsException();
            }
            balance -= amount;
        }

        @Override
        public String toString() {
            return "Account #" + accountNumber + " | Balance: $" + String.format("%.2f", balance);
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        BankAccount account = new BankAccount("1234", 100.0);

        try {
            account.deposit(-50);
        } catch (InvalidDepositException e) {
            System.out.println("Deposit Error: " + e.getMessage());
        }

        try {
            account.withdraw(150);
        } catch (InsufficientFundsException e) {
            System.out.println("Withdrawal Error: " + e.getMessage());
        }

        try {
            account.deposit(300);
        } catch (InvalidDepositException e) {
            System.out.println("Deposit Error: " + e.getMessage());
        }

        try {
            account.withdraw(100);
        } catch (InsufficientFundsException e) {
            System.out.println("Withdrawal Error: " + e.getMessage());
        }

        System.out.println(account);
    }
}
