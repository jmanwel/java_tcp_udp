package simple_tcp;
import java.net.Socket;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class Client {
    
    public Client() throws Exception {
        Socket socket = new Socket("localhost", 2020);
        System.out.println("Successfully connected to server!");

        BufferedReader in_socket = new BufferedReader (new InputStreamReader (socket.getInputStream()));
        PrintWriter out_socket = new PrintWriter(new OutputStreamWriter (socket.getOutputStream()), true);
        
        Scanner keyboard = new Scanner (System.in);
        String message = in_socket.readLine();
        System.out.println("Server says: " + message);
        message = keyboard.nextLine();
        out_socket.println(message);
        
        socket.close();  
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
