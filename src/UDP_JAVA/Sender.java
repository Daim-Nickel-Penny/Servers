package UDP_JAVA;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Sender {

    public  Sender()throws Exception{
        DatagramSocket socket=new DatagramSocket();
        Scanner keyboard=new Scanner(System.in);

        System.out.println("Enter The Message: ");
        String message=keyboard.nextLine();
        byte[] buffer=message.getBytes();
        DatagramPacket packet=new DatagramPacket(buffer, buffer.length,
                InetAddress.getByName("127.0.0.1"),2020);
        socket.send(packet);
        System.out.println("Sent: "+message);

        buffer = new byte[1500];
        packet = new DatagramPacket(buffer,buffer.length);
        socket.receive(packet);
        message=new String(buffer).trim();
        System.out.println("Recieved: "+message);

    }

    public static void main(String[] args) {
        try {
            new Sender();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
