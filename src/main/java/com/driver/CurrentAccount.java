package com.driver;

public class CurrentAccount extends BankAccount{
    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public void setTradeLicenseId(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }

    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        super(name,balance, 5000);

        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        try{
            if(balance < 5000){
                throw new Exception();
            }
        }catch(Exception e){
            System.out.println("Insufficient Balance");
        }

    }

//    public void validateLicenseId() throws Exception {
//        // A trade license Id is said to be valid if no two consecutive characters are same
//        // If the license Id is valid, do nothing
//        // If the characters of the license Id can be rearranged to create any valid license Id
//        // If it is not possible, throw "Valid License can not be generated" Exception
//
//    }
    public void validateLicenseId() throws Exception {
        // Count the occurrences of each character
        int[] charCount = new int[26]; // Assuming only uppercase English characters

        for (char c : tradeLicenseId.toCharArray()) {
            charCount[c - 'A']++;
        }

        // Check for consecutive characters that are the same
        for (int i = 0; i < tradeLicenseId.length() - 1; i++) {
            if (tradeLicenseId.charAt(i) == tradeLicenseId.charAt(i + 1)) {
                throw new Exception("Consecutive characters are not allowed in the license ID");
            }
        }

        // Check if characters can be rearranged to form a valid license ID
        boolean isValid = true;
        for (int count : charCount) {
            if (count > 2) {
                isValid = false;
                break;
            }
        }

        if (!isValid) {
            throw new Exception("Valid License can not be generated");
        }
    }


}
