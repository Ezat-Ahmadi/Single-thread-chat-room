import java.io.*;
import java.net.Socket;
import java.util.Scanner;

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

            String message;
            boolean isConnected = true;
            while(isConnected){
                Scanner scanner = new Scanner(System.in);
                message = scanner.nextLine();
                writer.println(message);
                writer.flush();
                String response = reader.readLine();
                System.out.println("server response :" + response);
                if(response.equals("god bye")){
                    isConnected = false;
                }
            }


            socket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}