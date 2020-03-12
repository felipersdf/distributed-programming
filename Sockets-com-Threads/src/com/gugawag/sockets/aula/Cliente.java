package com.gugawag.sockets.aula;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 5000);

        while(true) {
            System.out.print("Digite o texto: ");
            Scanner teclado = new Scanner(System.in);
            String texto = teclado.nextLine();

            DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
            saida.writeUTF(texto);

            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            System.out.println("Servidor falou: " + entrada.readUTF());
        }
    }
}
