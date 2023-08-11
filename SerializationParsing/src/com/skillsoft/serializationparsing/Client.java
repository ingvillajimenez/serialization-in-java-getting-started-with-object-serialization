package com.skillsoft.serializationparsing;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;

public class Client {

    public static void main(String[] args) throws IOException {

        System.out.println("*** Creating account objects");

        Account account1 = new Account(1010101, "Larry", 1555.5f);
        Account account2 = new Account(2020202, "Sergey", 3333.3f);
        Account account3 = new Account(3030303, "Mark", 13000f);
        Account account4 = new Account(4040404, "Travis", 27550f);

        List<Account> accountList = Arrays.asList(account1, account2, account3, account4);

        ObjectOutputStream objOut = null;

        try {
            Socket socket = new Socket(InetAddress.getLocalHost(), 8020);

            objOut = new ObjectOutputStream(
                    new BufferedOutputStream(socket.getOutputStream()));

            for (Account account : accountList) {

                System.out.println("Writing account to socket stream: \n" + account);

                objOut.writeObject(account);
                objOut.flush();

                Thread.sleep(5000);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error during serialization");
            System.exit(1);
        } finally {
            objOut.close();
        }
    }
}
