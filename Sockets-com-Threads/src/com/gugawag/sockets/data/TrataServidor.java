package com.gugawag.sockets.data;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class TrataServidor implements Runnable {

    private Socket servidor;

    public TrataServidor(Socket servidor) {
        this.servidor = servidor;
    }

    @Override public void run() {
        DataInputStream entrada = null;
        try {
            entrada = new DataInputStream(servidor.getInputStream());
            System.out.println("O servidor falou: " + entrada.readUTF());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
