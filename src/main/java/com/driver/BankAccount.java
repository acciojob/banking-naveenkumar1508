package com.driver;

public class BankAccount {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRemAmount() {
        return remAmount;
    }

    public void setRemAmount(int remAmount) {
        this.remAmount = remAmount;
    }

    private String name;
    private static double balance;

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {

        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;
    }

//    public String generateAccountNumber(int digits, int sum) throws Exception{
//        //Each digit of an account number can lie between 0 and 9 (both inclusive)
//        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
//        //If it is not possible, throw "Account Number can not be generated" exception
//
//        return null;
//    }
public String generateAccountNumber(int digits, int sum) throws Exception {
    return generateAccountNumberHelper(digits, sum, "");
}

    private String generateAccountNumberHelper(int digits, int sum, String prefix) throws Exception {
        if (digits == 0) {
            return (sum == 0) ? prefix : null;
        }

        for (int i = 0; i <= 9; i++) {
            String result = generateAccountNumberHelper(digits - 1, sum - i, prefix + i);
            if (result != null) {
                return result;
            }
        }

        throw new Exception("Account Number can not be generated");
    }

    public void deposit(double amount) {
        //add amount to balance
        this.balance = balance + amount;

    }

    int remAmount = 0;
    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance

        try{
            if(amount > 0 && balance > amount){
                balance = balance - amount;
                // previousTransaction = -amount;

                if(balance <= minBalance){
                    throw new Exception();
                }

            }
        }catch(Exception e){
            System.out.println("Insufficient Balance");
        }

    }


    public static double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}