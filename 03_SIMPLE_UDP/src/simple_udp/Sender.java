import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.util.Scanner;

public class Sender {

    public Sender() throws Exception {
        DatagramSocket socket = new DatagramSocket();
        Scanner keyboard = new Scanner(System.in);

        //send message
        System.out.println("Enter your message: ");
        String message = keyboard.nextLine();
        byte[] buffer = message.getBytes();
        DatagramPacket packet_s = new DatagramPacket(buffer, buffer.length, InetAddress.getByName("127.0.0.1"), 2020);
        socket.send(packet_s);
        System.out.println("--- Sent: " + message + "---");

        //receive message
        buffer = new byte[1500];
        packet_s = new DatagramPacket(buffer, buffer.length);

        socket.receive(packet_s);
        message = new String (buffer).trim();
        System.out.println("Received: " + message);
    }

    public static void main(String[] args){
        try {
            new Sender();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
