package com.skillsoft.serializationparsing;

import java.io.*;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("*** Reading objects with a serialVersionUID");

        String fileName = "apple_accounts.txt";

        try (ObjectInputStream objIn = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(fileName)))) {

            Account account1 = (Account) objIn.readObject();
            //Exception in thread "main" java.io.InvalidClassException: com.skillsoft.serializationparsing.Account; incompatible types for field accountNumber
            //	at java.base/java.io.ObjectStreamClass.matchFields(ObjectStreamClass.java:2357)
            //	at java.base/java.io.ObjectStreamClass.getReflector(ObjectStreamClass.java:2251)
            //	at java.base/java.io.ObjectStreamClass.initNonProxy(ObjectStreamClass.java:743)
            //	at java.base/java.io.ObjectInputStream.readNonProxyDesc(ObjectInputStream.java:1903)
            //	at java.base/java.io.ObjectInputStream.readClassDesc(ObjectInputStream.java:1772)
            //	at java.base/java.io.ObjectInputStream.readOrdinaryObject(ObjectInputStream.java:2060)
            //	at java.base/java.io.ObjectInputStream.readObject0(ObjectInputStream.java:1594)
            //	at java.base/java.io.ObjectInputStream.readObject(ObjectInputStream.java:430)
            //	at com.skillsoft.serializationparsing.Main.main(Main.java:17)
            //Exception in thread "main" java.io.InvalidClassException: com.skillsoft.serializationparsing.Account; local class incompatible: stream classdesc serialVersionUID = 1, local class serialVersionUID = 2
            //	at java.base/java.io.ObjectStreamClass.initNonProxy(ObjectStreamClass.java:689)
            //	at java.base/java.io.ObjectInputStream.readNonProxyDesc(ObjectInputStream.java:1903)
            //	at java.base/java.io.ObjectInputStream.readClassDesc(ObjectInputStream.java:1772)
            //	at java.base/java.io.ObjectInputStream.readOrdinaryObject(ObjectInputStream.java:2060)
            //	at java.base/java.io.ObjectInputStream.readObject0(ObjectInputStream.java:1594)
            //	at java.base/java.io.ObjectInputStream.readObject(ObjectInputStream.java:430)
            //	at com.skillsoft.serializationparsing.Main.main(Main.java:17)
            System.out.println("Account 1: " + account1);
            //Account 1: Account type: LOAN, Number: 1010101, Name: Steve Jobs, Balance: 1555.5

            Account account2 = (Account) objIn.readObject();
            System.out.println("Account 2: " + account2);
            //Account 2: Account type: LOAN, Number: 2020202, Name: Steve Wozniak, Balance: 3333.3
        }
        catch (ClassNotFoundException cnfe) {
            System.out.println("*** Thrown when the class read in using readObject() is not found");
        }
        finally {
            System.out.println("*** Completed reading objects from a ObjectInputStream");
        }

//        System.out.println("*** Writing objects with a serialVersionUID");
//
//        Account account1 = new Account(1010101, "Steve Jobs", 1555.5f);
//        Account account2 = new Account(2020202, "Steve Wozniak", 3333.3f);
//
//        String fileName = "apple_accounts.txt";
//
//        try (ObjectOutputStream objOut = new ObjectOutputStream(
//                new BufferedOutputStream(new FileOutputStream(fileName)))) {
//
//            objOut.writeObject(account1);
//            objOut.writeObject(account2);
//
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