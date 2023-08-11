package com.skillsoft.serializationparsing;

import java.io.Serializable;

public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    public static String accountType = "LOAN";

    private long accountNumber;
    private String customerName;
    private double loanBalance;

    public Account(long accountNumber, String customerName, double loanBalance) {

        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.loanBalance = loanBalance;
    }

    public static String getAccountType() {
        return accountType;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getLoanBalance() {
        return loanBalance;
    }

    @Override
    public String toString() {
        return String.format("Account type: %s, Number: %d, Name: %s, Balance: %.1f",
                accountType, accountNumber, customerName, loanBalance);
    }
}
