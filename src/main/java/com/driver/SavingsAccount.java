package com.driver;

import javax.xml.stream.XMLInputFactory;

public class SavingsAccount extends BankAccount{
    private static final double minBalance = 0;
     static double rate;
    double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        super(name,balance,minBalance);
        // minimum balance is 0 by default
      this.maxWithdrawalLimit = maxWithdrawalLimit;
      this.rate = rate;

    }
    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        if(amount > maxWithdrawalLimit){
            throw new Exception("Maximum Withdraw Limit Exceed");
        }
        // 2. "Insufficient Balance" : If the amount exceeds balance
        if(amount > getMinBalance()){
            throw new Exception("Insufficient Balance");
        }



    }

    public static double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
        // Calculate simple interest
        double interest = getBalance() * rate * years;
        return getBalance() + interest;

    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year

        // Calculate compound interest
        double compoundInterest = super.getBalance() * Math.pow((1 + rate / times), times * years);
        return compoundInterest;
    }

}
