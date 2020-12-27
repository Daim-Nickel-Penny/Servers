package UDP_JAVA;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Reciever {

    public Reciever() throws  Exception{

        DatagramSocket socket=new DatagramSocket(2020);
        System.out.println("Reciever is Running");
        Scanner keyboard=new Scanner(System.in);

        byte buffer[]=new byte[1500];//MTU
        DatagramPacket packet=new DatagramPacket(buffer,buffer.length);
        socket.receive(packet);//retreiving sender's message

        String message=new String(buffer).trim();
        System.out.println("Recived: "+message);

        InetAddress senders_address=packet.getAddress();
        int senders_port=packet.getPort();

        System.out.println("Enter The Message");
        message=keyboard.nextLine();

        buffer=message.getBytes();
        packet=new DatagramPacket(buffer, buffer.length, senders_address, senders_port);

        socket.send(packet);
        System.out.println("Sent: "+message);

    }


    public static void main(String[] args) {
        try {
            new Reciever();


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
