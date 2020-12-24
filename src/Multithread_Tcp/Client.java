package Multithread_Tcp;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public Client() throws IOException{
        Socket socket=new Socket("localhost",2020);
        System.out.println("Successful Connection Established to the Server.");

        BufferedReader in_socket=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out_socket=new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);

        Scanner keyboard=new Scanner(System.in);


        String message= in_socket.readLine();
        System.out.println("Server Says: "+message);
        message=keyboard.nextLine();
        out_socket.println(message);

        socket.close();
        System.out.println("Socket Closed.");
    }



    public static void main(String[] args) {
        try {
            new Client();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
