package com.gugawag.sockets.print;

import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) throws Exception {
        System.out.println("== Servidor no ar ==");
        ServerSocket server = new ServerSocket(5000);
        while(true) {
            Socket cliente = server.accept();
            TrataCliente trataCliente = new TrataCliente(cliente);
            Thread threadCliente = new Thread(trataCliente);
            threadCliente.start();
        }
    }
}
