package com.collection.mapinterface;

import java.util.*;

class BankingSystem {
    private Map<Integer, Double> accounts = new HashMap<>(); // Stores account balances
    private TreeMap<Double, Integer> sortedAccounts = new TreeMap<>(); // Sorts accounts by balance
    private Queue<Integer> withdrawalQueue = new LinkedList<>(); // Withdrawal request queue

    // Create a new account
    public void createAccount(int accountNumber, double balance) {
        accounts.put(accountNumber, balance);
        sortedAccounts.put(balance, accountNumber);
    }

    // Deposit money into an account
    public void deposit(int accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            double newBalance = accounts.get(accountNumber) + amount;
            sortedAccounts.remove(accounts.get(accountNumber)); // Remove old balance
            accounts.put(accountNumber, newBalance);
            sortedAccounts.put(newBalance, accountNumber); // Insert updated balance
            System.out.println("Deposited ₹" + amount + " into Account " + accountNumber);
        } else {
            System.out.println("Account not found: " + accountNumber);
        }
    }

    // Request a withdrawal (added to queue)
    public void requestWithdrawal(int accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            withdrawalQueue.add(accountNumber);
            System.out.println("Withdrawal request added for Account " + accountNumber);
        } else {
            System.out.println("Invalid account number: " + accountNumber);
        }
    }

    // Process withdrawal requests
    public void processWithdrawals() {
        System.out.println("\nProcessing Withdrawal Requests:");
        while (!withdrawalQueue.isEmpty()) {
            int accountNumber = withdrawalQueue.poll();
            if (accounts.containsKey(accountNumber)) {
                System.out.println("Processing withdrawal for Account " + accountNumber);
            } else {
                System.out.println("Account " + accountNumber + " not found.");
            }
        }
    }

    // Display all accounts sorted by balance
    public void displayAccountsByBalance() {
        System.out.println("\nAccounts Sorted by Balance:");
        for (Map.Entry<Double, Integer> entry : sortedAccounts.entrySet()) {
            System.out.println("Account " + entry.getValue() + entry.getKey());
        }
    }

    // Display all accounts
    public void displayAllAccounts() {
        System.out.println("\nAll Accounts:");
        for (Map.Entry<Integer, Double> entry : accounts.entrySet()) {
            System.out.println("Account " + entry.getKey() +  entry.getValue());
        }
    }
}

public class BankingSystemMain {
    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        // Creating accounts
        bank.createAccount(101, 50000);
        bank.createAccount(102, 20000);
        bank.createAccount(103, 75000);
        bank.createAccount(104, 15000);

        // Depositing money
        bank.deposit(101, 10000);
        bank.deposit(104, 5000);

        // Requesting withdrawals
        bank.requestWithdrawal(102);
        bank.requestWithdrawal(101);

        // Display accounts sorted by balance
        bank.displayAccountsByBalance();

        // Process withdrawals
        bank.processWithdrawals();

        // Display all accounts
        bank.displayAllAccounts();
    }
}