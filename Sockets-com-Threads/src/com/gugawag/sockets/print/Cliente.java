package com.gugawag.sockets.print;

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Cliente no ar ===");
        Socket socket = new Socket("localhost", 5000);
        OutputStream out;
        PrintStream saida = new PrintStream(socket.getOutputStream());
        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite uma mensagem: ");
        String texto = entrada.nextLine();
        saida.println(texto);
        saida.flush();
        TrataServidor trataServidor = new TrataServidor(socket);
        Thread threadServidor = new Thread(trataServidor);
        threadServidor.start();
    }

}
