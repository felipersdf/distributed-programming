package com.gugawag.sockets.data;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Cliente no ar ===");
        Socket socket = new Socket("localhost", 5000);

        DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
        while(true) {
            Scanner entrada = new Scanner(System.in);
            System.out.print("Digite uma mensagem: ");
            String texto = entrada.nextLine();
            saida.writeUTF(texto);
            TrataServidor trataServidor = new TrataServidor(socket);
            Thread threadServidor = new Thread(trataServidor);
            threadServidor.start();
        }
    }

}
