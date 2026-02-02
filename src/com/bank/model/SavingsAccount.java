package com.bank.model;

public class SavingsAccount extends Account {
    private static final double MIN_BALANCE = 1000;
    private static final double INTEREST_RATE = 0.04;

    public SavingsAccount(int accountNumber, String name, double balance) {
        super(accountNumber, name, balance);
    }

    @Override
    public void withdraw(double amount) {
        if(balance - amount >= MIN_BALANCE) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + " | New Balance: " + balance);
        } else {
            System.out.println("Cannot withdraw! Minimum balance of " + MIN_BALANCE + " must be maintained.");
        }
    }

    public void calculateInterest() {
        double interest = balance * INTEREST_RATE;
        balance += interest;
        System.out.println("Interest added: " + interest + " | New Balance: " + balance);
    }
}
