package br.edu.ifpb.gugawag.so.sockets;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Client {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1", 7000);
        System.out.println("Cliente iniciando...");
        System.out.println("\n\n ======== Menu =====" +
                "\n1 - readdir\n" +
                "2 - rename\n" +
                "3 - create\n" +
                "4 - remove\n");
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        while (true) {
            Scanner in = new Scanner(System.in);

            dos.writeUTF(in.nextLine());

            String retorno = dis.readUTF();

            System.out.println(retorno);
        }
    }
}


      //  Socket socket = new Socket("localhost", 7000);
      //  Scanner in = new Scanner(socket.getInputStream());


       // while(in.hasNextLine()) {
        //    System.out.println(in.nextLine());
       // }
       // in.close();
       // socket.close();
