package com.gugawag.sockets.aula;

import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Servidor no ar ===");

        ServerSocket serverSocket = new ServerSocket(5000);
        while (true) {
            Socket cliente = serverSocket.accept();
            TratadorCliente tratadorCliente = new TratadorCliente(cliente);
            tratadorCliente.start();
        }
    }
}
