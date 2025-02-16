package org.exceptionalhandling.banktransactionsystem;

// Creating a custom exception for handling insufficient balance cases
class InsufficientBalanceException extends Exception {
    // Passing a custom message to the Exception class
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

// Defining the BankAccount class for managing account balance and transactions
class BankAccount {
    private double balance;

    // Initializing the account with an initial balance
    public BankAccount(double initialBalance) {
        // Checking if the initial balance is negative
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative!");
        }
        // Setting the initial balance
        this.balance = initialBalance;
    }

    // Defining the withdraw method for processing withdrawals
    public void withdraw(double amount) throws InsufficientBalanceException {
        // Checking if the withdrawal amount is negative
        if (amount < 0) {
            // Throwing an exception for negative amount
            throw new IllegalArgumentException("Invalid amount!");
        }
        // Checking if there are sufficient funds for the withdrawal
        if (amount > balance) {
            // Throwing a custom exception for low balance
            throw new InsufficientBalanceException("Insufficient balance!");
        }
        // Deducting the withdrawal amount from the current balance
        balance -= amount;
        // Printing the updated balance
        System.out.println("Withdrawal successful, new balance: " + balance);
    }

    // Returning the current balance
    public double getBalance() {
        return balance;
    }
}

// Creating the main class to execute the Bank Transaction System
public class BankTransactionSystem {
    public static void main(String[] args) {
        // Creating a BankAccount object with an initial balance of 1000
        BankAccount account = new BankAccount(1000.0);

        try {
            // Printing the current balance
            System.out.println("Current balance: " + account.getBalance());
            // Trying to withdraw 500 (valid)
            account.withdraw(500.0);
            // Trying to withdraw 600 (causing an insufficient balance exception)
            account.withdraw(600.0);
        } catch (InsufficientBalanceException e) {
            // Handling InsufficientBalanceException and printing the error message
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            // Handling IllegalArgumentException for negative amounts and printing the error message
            System.out.println(e.getMessage());
        } finally {
            // Printing a message indicating that the transaction process is completed
            System.out.println("Transaction process completed.");
        }
    }
}