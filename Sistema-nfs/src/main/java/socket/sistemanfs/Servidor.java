package socket.sistemanfs;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Servidor {

        private static String HOME = "/home/oem/Documents/Github/distributed-programming/Sistema-nfs";

        public static void main(String[] args) throws IOException {
            System.out.println("== Servidor ==");

            Servidor server = new Servidor();

            ServerSocket serverSocket = new ServerSocket(5000);
            Socket socket = serverSocket.accept();

            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            DataInputStream dis = new DataInputStream(socket.getInputStream());


            while (true) {
                System.out.println("Cliente: " + socket.getInetAddress());

                String mensagem = dis.readUTF();
                System.out.println(mensagem);

                String[] arrayMessage = mensagem.split(" ");

                switch(arrayMessage[0]) {
                    case "readdir":
                        String msg = server.readdir(arrayMessage[1]);
                        if (msg != null) {
                            dos.writeUTF(msg);
                        } else {
                            dos.writeUTF("Diretório e/ou arquivo não existe(m)");
                        }
                        break;

                    case "rename":
                        if (server.rename(arrayMessage[1], arrayMessage[2])) {
                            dos.writeUTF("Arquivo renomeado!!");
                        } else {
                            dos.writeUTF("Diretório e/ou arquivo não existe(m)");
                        }
                        break;

                    case "create":
                        if (server.create(arrayMessage[1])) {
                            dos.writeUTF("Arquivo criado com sucesso!");
                        } else {
                            dos.writeUTF("Arquivo já existe");
                        }
                        break;

                    case "remove":
                        if (server.remove(arrayMessage[1])) {
                            dos.writeUTF("Arquivo removido com sucesso!");
                        } else {
                            dos.writeUTF("Arquivo não existe");
                        }
                        break;

                    default:
                        dos.writeUTF(arrayMessage[0] + " comando não reconhecido.");
                        break;
                }
            }
        }

        public String readdir (String diretorio) throws IOException {
            Path p = Paths.get(HOME+diretorio);
            if(Files.exists(p)) {
                Stream <Path> list = Files.list(p);
                return list.map(Path::getFileName)
                        .map(Object::toString)
                        .collect(Collectors.joining(", "));
            } else {
                return null;
            }
        }

        public boolean rename (String arquivo, String nomeNovo) throws IOException {
            Path p1 = Paths.get(HOME + arquivo);
            Path p2 = Paths.get(HOME + nomeNovo);
            if (Files.exists(p1)) {
                Files.move(p1, p2);
                return true;
            } else {
                return false;
            }
        }

        public boolean create (String arquivoNome) throws IOException {
            Path p = Paths.get(HOME + "\\" + arquivoNome);
            if (!Files.exists(p)) {
                return true;
            } else {
                return false;
            }
        }

        public boolean remove (String arquivoNome) throws IOException {
            Path p = Paths.get(HOME + arquivoNome);
            if (Files.exists(p)) {
                Files.delete(p);
                return true;
            } else {
                return false;
            }
        }
}


