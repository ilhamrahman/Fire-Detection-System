package com.example;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPReceiver {
    private final static int PACKETSIZE = 100;

    public static void main(String args[]) {
        // Check the arguments
//        if (args.length != 2)   //if the number of arguments do not include port and host
//        {
//            System.out.println("usage: UDPReceiver port");
//            return;
//        }

        DatagramSocket socket = null;

        try {
            // Convert the argument to ensure that is it valid
            //int port = Integer.parseInt(args[1]);                  //port number
            int port = 3600;
//            InetAddress host = InetAddress.getByName(args[0]);     //host address
            InetAddress host = InetAddress.getByName("10.0.0.53");
            socket = new DatagramSocket(port);                       //socket

            // Construct the socket
            //DatagramSocket socket = new DatagramSocket( port ) ;

            for (; ; ) {
                DatagramPacket packet = new DatagramPacket(new byte[PACKETSIZE], PACKETSIZE);   //initialize packet of data to be received
                socket.receive(packet);     //receive data
                String DataReceived = new String(packet.getData()).trim();   //string of data received
                System.out.println(DataReceived);


            }

        } catch (Exception e) {
            System.out.println(e);
        }


    }
}
