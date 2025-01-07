import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        int port = 8090;
        String host = "localhost";

        try (ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Server listening on port " + port);
            while(true){
                Socket socket = serverSocket.accept();
                System.out.println("New connection from " + socket.getRemoteSocketAddress());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}