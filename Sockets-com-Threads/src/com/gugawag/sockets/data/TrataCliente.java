package com.gugawag.sockets.data;

import java.io.DataInputStream;
import java.io.DataOutputStream;
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
        DataInputStream entrada = null;
        while (true) {
            try {
                entrada = new DataInputStream(cliente.getInputStream());
                System.out.println("O cliente falou: " + entrada.readUTF());
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                DataOutputStream saida = new DataOutputStream(cliente.getOutputStream());
                saida.writeUTF("recebi");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
