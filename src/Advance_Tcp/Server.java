package Advance_Tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public Server() throws Exception{

        ServerSocket server_socket =new ServerSocket(2020);
        System.out.println("Port 2020 started.");

        Socket socket=server_socket.accept();
        System.out.println("Client "+socket.getInetAddress()+" has connected");

        BufferedReader in_socket=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out_socket=new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);

        String message;
        int secret_number=(int)(Math.random()*10+1);
        do {
            out_socket.println("Enter the code [1-10]");
            message=in_socket.readLine();
        }while (!(Integer.parseInt(message)==secret_number));

        out_socket.println("Code Matched!!");
        System.out.println("Code is revealed. Exiting the App. ");

        /*out_socket.println("Welcome");
        String message=in_socket.readLine();
        System.out.println("Client Says: "+message);*/

        socket.close();
        System.out.println("Socket is closed.");

    }

    public static void main(String[] args) {
        try {
        new Server();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
