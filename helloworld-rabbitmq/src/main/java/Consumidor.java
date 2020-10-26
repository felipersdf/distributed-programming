import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class Consumidor {
    public static void main(String[] args) throws Exception {
        System.out.println("Consumidor");

        String NOME_FILA = "filaOla";

        //Criando a fábrica de conexões e criando uma conexão
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        connectionFactory.setUsername("mqadmin");
        connectionFactory.setPassword("admin123");

        Connection conexao = connectionFactory.newConnection();

        //Criando um canal e declarando uma fila
        Channel canal = conexao.createChannel();
        canal.queueDeclare(NOME_FILA, false, false, false, null);

        //Definindo a função callback
        DeliverCallback callback = (consumerTag, delivery) -> {
            String mensagem = new String(delivery.getBody());
            System.out.println("Recebi a mensagem: " + mensagem);
        };

        //Consumindo da fila
        canal.basicConsume(NOME_FILA, true, callback, consumerTag -> {});
        System.out.println("Continuarei executando outras atividades enquanto não chega mensagem...");
    }
}
