import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        int port = 8090;
        String host = "localhost";
        String username = "admin";
        try {
            Socket socket = new Socket(host,port);
            // reads server response from socket
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            // writes message for server to the socket
            OutputStream out = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(out,true);

            writer.println("Hello server I am "+ username);
            writer.flush();

            String response = reader.readLine();
            System.out.println("server response :"+ response);

            socket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}