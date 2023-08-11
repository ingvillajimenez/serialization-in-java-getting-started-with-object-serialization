package com.skillsoft.serializationparsing;

import java.io.*;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("*** Reading serializable objects using a ObjectInputStream");

        String fileName = "accounts.txt";

        try (ObjectInputStream objIn = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(fileName)))) {

            Account account1 = (Account) objIn.readObject();
            System.out.println("Account 1: " + account1);
            //Account 1: Account type: LOAN, Number: 11111, Name: Ada Lovelace, Balance: 20000.0

            Account account2 = (Account) objIn.readObject();
            System.out.println("Account 2: " + account2);
            //Account 2: Account type: LOAN, Number: 22222, Name: Charles Babbage, Balance: 15500.0
        }
        catch (ClassNotFoundException cnfe) {
            System.out.println("*** Thrown when the class read in using readObject() is not found");
        }
        finally {
            System.out.println("*** Completed reading objects from a ObjectInputStream");
        }

//        System.out.println("*** Trying to write a serializable class");
////        System.out.println("*** Trying to write a non-serializable class");
//
//        Account account1 = new Account(11111, "Ada Lovelace", 20000.0f);
//        Account account2 = new Account(22222, "Charles Babbage", 15500.0f);
//
//        String fileName = "accounts.txt";
//
//        try(ObjectOutputStream objOut = new ObjectOutputStream(
//                new BufferedOutputStream(new FileOutputStream(fileName)))) {
//
//            objOut.writeObject(account1);
//            //java.io.NotSerializableException: com.skillsoft.serializationparsing.Account
//            //	at java.base/java.io.ObjectOutputStream.writeObject0(ObjectOutputStream.java:1185)
//            //	at java.base/java.io.ObjectOutputStream.writeObject(ObjectOutputStream.java:349)
//            //	at com.skillsoft.serializationparsing.Main.main(Main.java:20)
//            objOut.writeObject(account2);
//        }
//        catch (NotSerializableException nse) {
//            nse.printStackTrace();
//        }
//        finally {
//            System.out.println("*** Completed writing serializable objects using ObjectOutputStream");
////            System.out.println("*** Completed writing non-serializable objects using ObjectOutputStream");
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