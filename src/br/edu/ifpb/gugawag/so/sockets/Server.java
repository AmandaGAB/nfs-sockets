package br.edu.ifpb.gugawag.so.sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Server {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(7000);
        System.out.println("---------- Servidor iniciado ----------");
        Socket clientSocket = serverSocket.accept();
        DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());
        DataInputStream dis = new DataInputStream(clientSocket.getInputStream());

        while(true) {

            String op = dis.readUTF();
            switch(op){
                case "1":

                    System.out.println("== Enviando Lista de nomes ==");

                    Path arquivo = Paths.get("C:/Users/Amanda/Documents/GitHub/nfs-sockets/arquivo.txt");

                    if(Files.isReadable(arquivo))
                        dos.writeUTF("Nome do arquivo:"+ arquivo.getFileName());
                        System.out.println(Files.readAllLines(arquivo).toString());
                        dos.writeUTF("Lista de nomes:"+Files.readAllLines(arquivo).toString());

                case "2":
//                    Path novo = Files.createFile(Paths.get("C:/Users/Amanda/Documents/GitHub/nfs-sockets/novo.txt"));
                    File arquivo1 = new File("C:/Users/Amanda/Documents/GitHub/nfs-sockets/arquivo.txt");
                    arquivo1.renameTo(new File("C:/Users/Amanda/Documents/GitHub/nfs-sockets/novo.txt"));

                    dos.writeUTF("Execute o readdir novamente!");

                case "3":

                    Path novo = Files.createFile(Paths.get("C:/Users/Amanda/Documents/GitHub/nfs-sockets/novo.txt"));

                    dos.writeUTF("O arquivo"+novo.getFileName() + "foi criado!");

                case "4":

                   Files.delete(Paths.get("C:/Users/Amanda/Documents/GitHub/nfs-sockets/arquivo.txt"));
                    dos.writeUTF("Um arquivo foi deletado!");
            }


        }
        
       // while(true) {
       //     Socket clientSocket = serverSocket.accept();
       //     System.out.println("Cliente " + clientSocket.getInetAddress() + ":" + clientSocket.getPort());

       ///     PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
        //    out.println("Tchau!");
        //    out.close();
         //   clientSocket.close();
        }

    }

