package com.skillsoft.serializationparsing;

import java.io.Externalizable; // interface Externalizable
import java.io.IOException; // class IOException
import java.io.ObjectInput; // interface ObjectInput
import java.io.ObjectOutput; // interface ObjectOutput
import java.util.Arrays; // class Arrays

public class Account implements Externalizable {

    private static final long serialVersionUID = 1L;

    public static String accountType = "LOAN";

    private long accountNumber;
    private String customerName;
    private double loanBalance;
    private int creditScore;
    private String[] tags;

    public Account() {
    }

    public Account(long accountNumber, String customerName, double loanBalance,
                   int creditScore, String... tags) {

        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.loanBalance = loanBalance;
        this.creditScore = creditScore;
        this.tags = tags;
    }

    @Override
    public String toString() {
        return String.format("{Type: %s, Number: %d, Name: %s, Balance: %.1f, Credit score: %d, Tags: %s}\n",
                accountType, accountNumber, customerName, loanBalance, creditScore, Arrays.toString(tags));
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeLong(accountNumber);
        out.writeUTF(customerName);
        out.writeDouble(loanBalance);
        out.writeUTF(Arrays.toString(tags));
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.accountNumber = in.readLong();
        this.customerName = in.readUTF();
        this.loanBalance = in.readDouble();

        String tagString = in.readUTF();
        tagString = tagString.substring(1, tagString.length() - 1);

        this.tags = tagString.split(", ");
    }
}
