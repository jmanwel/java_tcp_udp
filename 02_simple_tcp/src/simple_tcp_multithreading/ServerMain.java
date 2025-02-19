import java.net.ServerSocket;
import java.net.Socket;


public class ServerMain {
    
    public ServerMain() throws Exception {
        ServerSocket server_socket = new ServerSocket(2020);
        System.out.println("Port 2020 is now open");
        while(true){
            Socket socket = server_socket.accept();
            ServerThread server_thread = new ServerThread(socket, this);
            Thread thread = new Thread(server_thread);
            thread.start();
        }
    }

    private int clientNumber = 1;

    public int getClientNumber(){
        return clientNumber ++;
    }

    public static void main(String[] args){
        try {
            new ServerMain();
        }
        catch (Exception e){
            //Handle exception
            e.printStackTrace();
        }
    }
}
