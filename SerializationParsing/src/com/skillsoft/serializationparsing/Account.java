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

    @Override
    public String toString() {
        return String.format("{%s, %d, %s, %.1f}\n",
                accountType, accountNumber, customerName, loanBalance);
    }
}
