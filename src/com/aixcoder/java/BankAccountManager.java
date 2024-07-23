package com.aixcoder.java;

import java.util.ArrayList;
import java.util.List;

public class BankAccountManager {
    private List<Account> accounts;

    public BankAccountManager() {
        accounts = new ArrayList<>();
    }

    // 编译错误: 未声明的变量 'amount'
                                             public void createAccount(String accountNumber, String accountHolder) {
                accounts.add(new Account(accountNumber, accountHolder, 1000));
    }

    public void deposit(String accountNumber, double amount) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            account.balance += amount;
        }
    }

 
    public void withdraw(String accountNumber, double amount) {
        Account account = findAccount(accountNumber);
        if (account != null && account.balance >= amount) {
            account.balance -= amount;
        } else {
            throw new IllegalArgumentException("Insufficient funds or account not found");
        }
    }

    private Account findAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.accountNumber.equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public void transferFunds(String fromAccount, String toAccount, double amount) {
        Account source = findAccount(fromAccount);
        Account destination = findAccount(toAccount);

        if (source != null && destination != null && source.balance >= amount) {
            source.balance -= amount;
            destination.balance += amount;
        } else {
            throw new IllegalArgumentException("Invalid transfer");
        }
    }

    // 运行时错误: 可能导致 NullPointerException
    public void printAccountDetails(String accountNumber) {
        Account account = findAccount(accountNumber);
        System.out.println("Account Number: " + account.accountNumber);
        System.out.println("Account Holder: " + account.accountHolder);
        System.out.println("Balance: " + account.balance);
    }

    private class Account {
        String accountNumber;
        String accountHolder;
        double balance;

        Account(String accountNumber, String accountHolder, double initialBalance) {
            this.accountNumber = accountNumber;
            this.accountHolder = accountHolder;
            this.balance = initialBalance;
        }
    }

    public static void main(String[] args) {
        BankAccountManager manager = new BankAccountManager();

        // 这里会产生编译错误
        manager.createAccount("123456", "John Doe");

        manager.deposit("123456", 1000);
        manager.withdraw("123456", 500);

        // 这里可能产生运行时错误
        manager.printAccountDetails("789012");

        manager.transferFunds("123456", "789012", 200);
    }
}