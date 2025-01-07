import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        int port = 8090;
        String host = "localhost";
        String username = "admin";
        try {
            Socket socket = new Socket(host,port);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}