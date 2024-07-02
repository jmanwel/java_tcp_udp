package simple_tcp;
import java.net.Socket;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;

public class Client {
    
    public Client() throws Exception {
        Socket socket = new Socket("localhost", 2020);
        System.out.println("Successfully connected to server");

        // I/O Stream
        BufferedReader in_socket = new BufferedReader (new InputStreamReader (socket.getInputStream()));
        PrintWriter out_socket = new PrintWriter(new OutputStreamWriter (socket.getOutputStream()), true);
        String message = in_socket.readLine();
        System.out.println("Server says: " + message);
        out_socket.println("Thanks!");
        socket.close();
        System.out.println("Socket closed");
    }

    public static void main(String[] args){
        try{
            new Client();
        }
        catch (Exception e) {
            //Handle exception
            e.printStackTrace();
        }
    }
}
