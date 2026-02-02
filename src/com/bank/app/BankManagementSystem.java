package com.bank.app;

import com.bank.controller.BankController;

public class BankManagementSystem {
    public static void main(String[] args) {
        BankController controller = new BankController();
        controller.start();
    }
}
