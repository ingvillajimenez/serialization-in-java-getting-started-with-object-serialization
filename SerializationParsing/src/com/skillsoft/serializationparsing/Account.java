package com.skillsoft.serializationparsing;

import java.io.Serializable;
import java.math.BigInteger;

public class Account implements Serializable {
    private static final long serialVersionUID = 1L;

    public static String accountType = "LOAN";

    private long accountNumber;
    private String customerName;
    private double loanBalance;

    private CreditCard creditCard;

    public Account(long accountNumber, String customerName, double loanBalance, String cardType) {

        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.loanBalance = loanBalance;

        this.creditCard = new CreditCard(cardType);
    }

    @Override
    public String toString() {
        return String.format("Account type: %s, Number: %d, Name: %s, Balance: %.1f, %s\n",
                accountType, accountNumber, customerName, loanBalance, creditCard);
    }
}
