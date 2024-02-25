package com.driver;

public class Main {
    public static void main(String[] args) throws Exception {

        BankAccount BankAccount = new BankAccount("Naveen kumar", 10000, 5000);

        BankAccount.deposit(5000);
        BankAccount.withdraw(5000);

        CurrentAccount currAccount = new CurrentAccount("Rakesh",10000,"UREA");
        //currAccount.validateLicenseId();

        SavingsAccount saveAccounts = new SavingsAccount("nk",10000,5000,2);
        SavingsAccount.getSimpleInterest(2);
        saveAccounts.getCompoundInterest(2,3);
    }

   }