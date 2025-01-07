import java.io.IOException;
import java.net.ServerSocket;

public class Server {

    public static void main(String[] args) {
        int port = 8090;
        String host = "localhost";

        try (ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Server listening on port " + port);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}