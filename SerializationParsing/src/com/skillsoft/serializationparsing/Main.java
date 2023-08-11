package com.skillsoft.serializationparsing;

import java.io.*;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("*** Reading objects with a transient field");

        String fileName = "microsoft_accounts.txt";

        try (ObjectInputStream objIn = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(fileName)))) {

            Account account1 = (Account) objIn.readObject();
            System.out.println("Account 1: " + account1);
            //Account 1: Account type: LOAN, Number: 11001100, Name: Bill Gates, Balance: 0.0, Notes: Fast track loan repayment

            Account account2 = (Account) objIn.readObject();
            System.out.println("Account 2: " + account2);
            //Account 2: Account type: LOAN, Number: 22002200, Name: Paul Allen, Balance: 0.0, Notes: Special repayment terms
        }
        catch (ClassNotFoundException cnfe) {
            System.out.println("*** Thrown when the class read in using readObject() is not found");
        }
        finally {
            System.out.println("*** Completed reading objects from a ObjectInputStream");
        }

//        System.out.println("*** Saving objects with transient fields");
//
//        Account account1 = new Account(11001100, "Bill Gates", 12000.0f);
//        account1.setAdditionalNotes("Fast track loan repayment");
//
//        Account account2 = new Account(22002200, "Paul Allen", 6000.5f);
//        account2.setAdditionalNotes("Special repayment terms");
//
//        String fileName = "microsoft_accounts.txt";
//
//        try (ObjectOutputStream objOut = new ObjectOutputStream(
//                new BufferedOutputStream(new FileOutputStream(fileName)))) {
//
//            objOut.writeObject(account1);
//            objOut.writeObject(account2);
//        }
//        catch (NotSerializableException nse) {
//            nse.printStackTrace();
//        }
//        finally {
//            System.out.println("*** Completed writing objects using ObjectOutputStream");
//        }

    }
}

// Wire Protocol or Format
// Represent information at the application level that allows us to get data from point A to point B

// Serializable
// Convert the state of an object to a byte stream that can be reverted back to the object

// Serializable Interface
// Marker interface which contains no data members or methods

// Serialization and Deserialization
// Converting to byte stream and reconverting to object format

// Managing Class Versions
// Objects serialized using one version of a class MAY NOT be compatible with new versions

// serialVersionUID
// Used to remember versions of a serializable class

// Backward Compatible
// Adding a new field means your class can still read serialized versions of older objects

// The "transient" keyword
// Used to specify fields which should NOT be serialized