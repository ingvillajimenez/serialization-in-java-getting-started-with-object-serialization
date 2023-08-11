package com.skillsoft.serializationparsing;

import java.io.*;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("*** Reading records using a ObjectInputStream");
        System.out.println("*** Casting to the wrong class");

        String productFilename = "products.txt";

        try(ObjectInputStream objIn = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(productFilename)))) {

            for (int i = 0; i < 3; i++) {

                String productId = (String) objIn.readObject();
                //Exception in thread "main" java.lang.ClassCastException: class java.math.BigInteger cannot be cast to class java.lang.String (java.math.BigInteger and java.lang.String are in module java.base of loader 'bootstrap')
                //	at com.skillsoft.serializationparsing.Main.main(Main.java:20)
//                BigInteger productId = (BigInteger) objIn.readObject();
                String productName = objIn.readUTF();
                float productPrice = (float) objIn.readFloat();

                System.out.format("Product ID: %d, Name: %s, Price: %.1f\n",
                        productId, productName, productPrice);
                //Product ID: 23400000023, Name: Samsung TV, Price: 1600.0
                //Product ID: 34556000002, Name: Adidas Shoes, Price: 199.9
                //Product ID: 98750000033, Name: iPhone 6s, Price: 599.0
            }
        }
        catch (ClassNotFoundException cnfe) {
            System.out.println("*** Thrown when the class read in using readObject() is not found");
        }
        finally {
            System.out.println("*** Completed reading records from a ObjectInputStream");
        }

//        System.out.println("*** ObjectOutputStream to write objets to disk");
//        System.out.println("*** Supports primitive types as well as objects");
//
//        BigInteger productIds[] = {
//                new BigInteger("23400000023"),
//                new BigInteger("34556000002"),
//                new BigInteger("98750000033")
//        };
//
//        String[] productNames = new String[] {"Samsung TV", "Adidas Shoes", "iPhone 6s"};
//        float[] productPrices = new float[] {1599.99f, 199.95f, 599.0f};
//
//        System.out.println("BigInteger implements Serializable" +
//                (productIds[0] instanceof Serializable)); // true
//        System.out.println("String implements Serializable" +
//                (productNames[0] instanceof Serializable)); // true
//        System.out.println("float implements Serializable" +
//                (Float.valueOf(productPrices[0]) instanceof Serializable)); // true
//
//        String productFilename = "products.txt";
//
//        try(ObjectOutputStream objOut = new ObjectOutputStream(
//                new BufferedOutputStream(new FileOutputStream(productFilename)))) {
//
//            for (int i = 0; i < productIds.length; i++) {
//
//                objOut.writeObject(productIds[i]);
//                objOut.writeUTF(productNames[i]);
//                objOut.writeFloat(productPrices[i]);
//            }
//
//        } finally {
//            System.out.println("*** Completed writing records to a ObjectOutputStream");
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