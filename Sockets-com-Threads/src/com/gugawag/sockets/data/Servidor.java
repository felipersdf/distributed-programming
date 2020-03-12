package com.gugawag.sockets.data;

import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) throws Exception {
        System.out.println("== Servidor no ar ==");
        ServerSocket server = new ServerSocket(5000);
        while(true) {
            Socket cliente = server.accept();
            System.out.println("== Servidor aceitou cliente e vai aguardar novo ==");
            TrataCliente trataCliente = new TrataCliente(cliente);
            Thread threadCliente = new Thread(trataCliente);
            threadCliente.start();
        }
    }
}
