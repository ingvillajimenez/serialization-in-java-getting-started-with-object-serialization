package com.skillsoft.serializationparsing;

import java.io.Serializable;
import java.math.BigInteger;

public class Account implements Serializable {

    private static final long serialVersionUID = 2L;
//    private static final long serialVersionUID = 1L;

    public static String accountType = "LOAN";

    private BigInteger accountNumber;
//    private long accountNumber;
    private String customerName;
    private double loanBalance;

    private String additionalNotes;

    public Account(BigInteger accountNumber, String customerName, double loanBalance) {
//    public Account(long accountNumber, String customerName, double loanBalance) {

        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.loanBalance = loanBalance;
    }

    public static String getAccountType() {
        return accountType;
    }

    public BigInteger getAccountNumber() {
//    public long getAccountNumber() {
        return accountNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getLoanBalance() {
        return loanBalance;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }

    @Override
    public String toString() {
        return String.format("Account type: %s, Number: %d, Name: %s, Balance: %.1f, Notes: %s",
                accountType, accountNumber, customerName, loanBalance, additionalNotes);
    }
}
