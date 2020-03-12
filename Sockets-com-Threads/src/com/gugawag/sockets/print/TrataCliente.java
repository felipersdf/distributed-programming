package com.gugawag.sockets.print;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class TrataCliente implements Runnable {

    private Socket cliente;
    public TrataCliente(Socket cliente) {
        this.cliente = cliente;
    }
    @Override public void run() {
        Scanner entrada = null;
        try {
            entrada = new Scanner(cliente.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (entrada.hasNextLine()) {
            System.out.println("O cliente falou: " + entrada.nextLine());
        }
        try {
            System.out.println("servidor1");
            PrintStream saida = new PrintStream(cliente.getOutputStream());
            saida.println("recebi");
            saida.flush();
            System.out.println("servidor2");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
