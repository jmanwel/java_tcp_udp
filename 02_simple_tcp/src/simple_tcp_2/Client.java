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
        String user_number = "0";
        ArrayList<String> valid_inputs = new ArrayList<>();
        valid_inputs.add("1");
        valid_inputs.add("2");
        valid_inputs.add("3");
        valid_inputs.add("4");
        valid_inputs.add("5");
        valid_inputs.add("6");
        valid_inputs.add("7");
        valid_inputs.add("8");
        valid_inputs.add("9");
        valid_inputs.add("10");

        while(in_socket.readLine().startsWith("Guess")){
            boolean valid = false;
            while(valid == false ){
                System.out.println("Guess a number [1-10]: ");
                user_number = keyboard.nextLine();
                valid = valid_inputs.contains(user_number);
            }            
            out_socket.println(user_number);
        }
        System.out.println("Got it!");
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
