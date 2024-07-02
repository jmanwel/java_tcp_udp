package simple_tcp;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;

public class Server {

    public Server() throws Exception {
        ServerSocket server_socket = new ServerSocket(2020);
        System.out.println("Port 2020 open");
        Socket socket = server_socket.accept();
        System.out.println("Client " + socket.getInetAddress() + " has connected.");

        BufferedReader in_socket = new BufferedReader(new InputStreamReader (socket.getInputStream()));
        PrintWriter out_socket = new PrintWriter(new OutputStreamWriter (socket.getOutputStream()), true);
        String message;
        int secret_number = (int)(Math.random()*10+1);

        do {
            out_socket.println("Guess a number [1-10]: ");
            message = in_socket.readLine();
        } while ( (Integer.parseInt(message)) != secret_number );

        out_socket.println(secret_number);
        System.out.println("Got it!!!!!!!!!");
        socket.close();
        System.out.println("Socket closed");
    }

    public static void main(String[] args){
        try {
            new Server();
        }
        catch (Exception e){
            //Handle exception
            e.printStackTrace();
        }
    }
}
