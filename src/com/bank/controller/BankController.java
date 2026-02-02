package com.bank.controller;

import com.bank.model.*;
import com.bank.view.BankView;
import java.util.*;

public class BankController {
    private HashMap<Integer, Account> accounts = new HashMap<>();
    private Scanner sc = new Scanner(System.in);
    private BankView view = new BankView();

    public void start() {
        while(true) {
            view.showMenu();
            int choice = sc.nextInt();

            switch(choice) {
                case 1:
                    System.out.print("Enter Account Number: ");
                    int accNo1 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name1 = sc.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    double bal1 = sc.nextDouble();
                    accounts.put(accNo1, new SavingsAccount(accNo1, name1, bal1));
                    System.out.println("Savings Account created!");
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    int accNo2 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name2 = sc.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    double bal2 = sc.nextDouble();
                    accounts.put(accNo2, new SalaryAccount(accNo2, name2, bal2));
                    System.out.println("Salary Account created!");
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    int accNo3 = sc.nextInt();
                    System.out.print("Enter Amount: ");
                    double dep = sc.nextDouble();
                    if(accounts.containsKey(accNo3)) accounts.get(accNo3).deposit(dep);
                    else System.out.println("Account not found!");
                    break;

                case 4:
                    System.out.print("Enter Account Number: ");
                    int accNo4 = sc.nextInt();
                    System.out.print("Enter Amount: ");
                    double wd = sc.nextDouble();
                    if(accounts.containsKey(accNo4)) accounts.get(accNo4).withdraw(wd);
                    else System.out.println("Account not found!");
                    break;

                case 5:
                    System.out.print("Enter Account Number: ");
                    int accNo5 = sc.nextInt();
                    if(accounts.containsKey(accNo5))
                        System.out.println("Balance: " + accounts.get(accNo5).getBalance());
                    else System.out.println("Account not found!");
                    break;

                case 6:
                    System.out.print("Enter Account Number: ");
                    int accNo6 = sc.nextInt();
                    if(accounts.containsKey(accNo6)) accounts.get(accNo6).displayDetails();
                    else System.out.println("Account not found!");
                    break;

                case 7:
                    System.out.print("Enter Account Number: ");
                    int accNo7 = sc.nextInt();
                    if(accounts.containsKey(accNo7)) {
                        Account acc = accounts.get(accNo7);
                        if(acc instanceof SavingsAccount) {
                            ((SavingsAccount) acc).calculateInterest();
                        } else if(acc instanceof SalaryAccount) {
                            ((SalaryAccount) acc).calculateInterest();
                        }
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 8:
                    System.out.println("Thank you for banking with us!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
