package com.gugawag.sockets.aula;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class TratadorCliente extends Thread {

    private Socket cliente;
    public TratadorCliente(Socket cliente) {
        this.cliente = cliente;
    }

    public void run() {
        DataInputStream entrada = null;
        while(true) {
            try {
                entrada = new DataInputStream(cliente.getInputStream());
                System.out.println("o cliente falou " + entrada.readUTF());
                DataOutputStream saida = new DataOutputStream(cliente.getOutputStream());
                saida.writeUTF("recebi");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
