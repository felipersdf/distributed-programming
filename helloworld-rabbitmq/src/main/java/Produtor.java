import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;

public class Produtor {
    public static void main(String[] args) throws Exception{
        //Criacão de uma factory de conexão, responsável por criar as conexões
        ConnectionFactory connectionFactory = new ConnectionFactory();

        //Localização do gestor da fila (Queue Manager)
        connectionFactory.setHost("localhost");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("mqadmin");
        connectionFactory.setPassword("admin123");

        String NOME_FILA = "filaOla";
        try(
                //Criação de uma conexão
                Connection connection = connectionFactory.newConnection();
                //Criando um canal na conexão
                Channel channel = connection.createChannel()) {
            //Esse corpo especifica o envio da mensagem para a fila

            //Declaração da fila. Se não existir ainda no queue manager, será criada. Se já existir e foi criada com
            // os mesmos parâmetros, pega a referência da fila. Se foi criada com parâmetros diferentes, lança uma exceção
            channel.queueDeclare(NOME_FILA, false, false, false, null);
            String mensagem = "Olá Felipe!!";
            //Publica uma mensagem na fila
            channel.basicPublish("", NOME_FILA, null, mensagem.getBytes());
            System.out.println("Enviei mensagem: " + mensagem);
        }
    }
}
