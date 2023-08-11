package com.skillsoft.serializationparsing;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        String fileName = "accounts_with_tags.txt";

        try (ObjectInputStream objIn = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(fileName)))) {

            Account account1 = (Account) objIn.readObject();
            //Exception in thread "main" java.io.InvalidClassException: com.skillsoft.serializationparsing.Account; no valid constructor
            //	at java.base/java.io.ObjectStreamClass$ExceptionInfo.newInvalidClassException(ObjectStreamClass.java:159)
            //	at java.base/java.io.ObjectStreamClass.checkDeserialize(ObjectStreamClass.java:864)
            //	at java.base/java.io.ObjectInputStream.readOrdinaryObject(ObjectInputStream.java:2061)
            //	at java.base/java.io.ObjectInputStream.readObject0(ObjectInputStream.java:1594)
            //	at java.base/java.io.ObjectInputStream.readObject(ObjectInputStream.java:430)
            //	at com.skillsoft.serializationparsing.Main.main(Main.java:15)
            System.out.println("Account 1: " + account1);
            //Account 1: {Type: LOAN, Number: 1010101, Name: Larry, Balance: 1555.5, Credit score: 0, Tags: [Founder, Hi potential]}

            Account account2 = (Account) objIn.readObject();
            System.out.println("Account 2: " + account2);
            //Account 2: {Type: LOAN, Number: 2020202, Name: Sergey, Balance: 3333.3, Credit score: 0, Tags: [High income, Hi potential, Reliable]}

            Account account3 = (Account) objIn.readObject();
            System.out.println("Account 3: " + account3);
            //Account 3: {Type: LOAN, Number: 3030303, Name: Mark, Balance: 13000.0, Credit score: 0, Tags: [New]}

            Account account4 = (Account) objIn.readObject();
            System.out.println("Account 4: " + account4);
            //Account 4: {Type: LOAN, Number: 4040404, Name: Travis, Balance: 27550.0, Credit score: 0, Tags: [New]}
        }
        catch (ClassNotFoundException cnfe) {
            System.out.println("*** Thrown when the class read in using readObject() is not found");
        }
        finally {
            System.out.println("*** Completed reading objects from a ObjectInputStream");
        }

//        Account account1 = new Account(1010101, "Larry", 1555.5,
//                647, "Founder", "Hi potential");
//        Account account2 = new Account(2020202, "Sergey", 3333.3,
//                689, "High income", "Hi potential", "Reliable");
//        Account account3 = new Account(3030303, "Mark", 13000,
//                644, "New");
//        Account account4 = new Account(4040404, "Travis", 27550,
//                689, "New");
//
//        List<Account> accountList = Arrays.asList(account1, account2, account3, account4);
//
//        String fileName = "accounts_with_tags.txt";
//
//        try (ObjectOutputStream objOut = new ObjectOutputStream(
//                new BufferedOutputStream(new FileOutputStream(fileName)))) {
//
//            for (Account account : accountList) {
//                System.out.println("Writing: " + account);
//                objOut.writeObject(account);
//                //Writing: {Type: LOAN, Number: 1010101, Name: Larry, Balance: 1555.5, Credit score: 647, Tags: [Founder, Hi potential]}
//                //
//                //Writing: {Type: LOAN, Number: 2020202, Name: Sergey, Balance: 3333.3, Credit score: 689, Tags: [High income, Hi potential, Reliable]}
//                //
//                //Writing: {Type: LOAN, Number: 3030303, Name: Mark, Balance: 13000.0, Credit score: 644, Tags: [New]}
//                //
//                //Writing: {Type: LOAN, Number: 4040404, Name: Travis, Balance: 27550.0, Credit score: 689, Tags: [New]}
//            }
//        } catch (NotSerializableException nse) {
//            nse.printStackTrace();
//        } finally {
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

// Socket
// An endpoint of a two-way communication link between two applications on the same network

// Localhost
// 127.0.0.1

// ServerSocket
// System independent implementation of the server side of a client/server socket connection

// The Externalizable Interface
// Custom serialization and deserialization of objects

// Tags in Serialized Form
// ["tag1", "tag2", "tag3"]