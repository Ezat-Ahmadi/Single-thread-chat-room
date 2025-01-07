import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) {
        int port = 8090;
        String host = "localhost";

        try (ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Server listening on port " + port);
            while(true){
                Socket socket = serverSocket.accept();
                System.out.println("New connection from -> " + socket.getRemoteSocketAddress());
                // this stream reads the data sent from client
                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                //this stream respond to client
                OutputStream output = socket.getOutputStream();
                PrintWriter out = new PrintWriter(output, true);

                String recievedMessage;
                while((recievedMessage = reader.readLine()) != null){
                    System.out.println("received from client "+recievedMessage);
                    Scanner scanner = new Scanner(System.in);
                    String respond = scanner.nextLine();
                    out.println(respond);
                }
                socket.close();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}