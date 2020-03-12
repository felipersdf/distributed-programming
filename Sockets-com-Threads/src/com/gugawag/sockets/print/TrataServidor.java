package com.gugawag.sockets.print;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class TrataServidor implements Runnable {

    private Socket servidor;

    public TrataServidor(Socket servidor) {
        this.servidor = servidor;
    }

    @Override public void run() {
        System.out.println("cliente1");
        Scanner entrada = null;
        try {
            entrada = new Scanner(servidor.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("cliente2");
        while (entrada.hasNextLine()) {
            System.out.println("O servidor falou: " + entrada.nextLine());
        }
    }
}
