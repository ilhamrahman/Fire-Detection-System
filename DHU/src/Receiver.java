import java.io.IOException;
import java.net.*;
import org.json.*;

import java.net.*;
import java.util.Arrays;

public class Receiver {
	private final static int PACKETSIZE = 100 ;

	public static void main( String args[] )
	{
	      // Check the arguments
	      if( args.length != 2 )   //if the number of arguments do not include port and host
	      {
	         System.out.println( "usage: UDPReceiver port" ) ;
	         return ;
	      }
	      
	      DatagramSocket socket = null ;  
	      
	      try
	      {
	         // Convert the argument to ensure that is it valid
	         int port = Integer.parseInt( args[1] ) ;                  //port number   
	         InetAddress host = InetAddress.getByName( args[0] ) ;     //host address
	         socket = new DatagramSocket(port) ;                       //socket

	         // Construct the socket
	         //DatagramSocket socket = new DatagramSocket( port ) ;
	         
	         for( ;; )
	         {
		         DatagramPacket packet = new DatagramPacket( new byte[PACKETSIZE], PACKETSIZE ) ;   //initialize packet of data to be received
	             socket.receive( packet ) ;     //receive data
	             String DataReceived = new String(packet.getData()).trim();   //string of data received
	             DataAnalysis data = new DataAnalysis(DataReceived);     //call DataAnalysis constructor to split the string of data into 3 parts 
	             
	             Sender sender = new Sender();     //initialize sender
	             float temp = data.getTemp();  //current temperature value
	             String tempMessage = sender.tempMessage(data.isTempHigh());   //message for temperature status
	             String fireMessage = sender.fireMessage(data.isFireDetected());   //message for fire status
	             String smokeMessage = sender.smokeMessage(data.isSmokeDetected());   //message for smoke status
	  
	          
	             sender.send(temp, tempMessage, fireMessage, smokeMessage);     //send the data to the android application
	         
	         }
	         
	     }
	     catch( Exception e )
	     {
	        System.out.println( e ) ;
	     }
	     
	     
}
}


/*
public class Receiver {
	
	static InetAddress host;

    public static void main(String[] args) throws UnknownHostException {
        int port = args.length == 0 ? 57 : Integer.parseInt(args[0]);
    	//if( args.length != 2 )
	      //{
	        // System.out.println( "usage: java UDPSender host port" ) ;
	         //return ;
	      //}
    	//int port = Integer.parseInt( args[0] ) ;
    	host = InetAddress.getByName( args[1] ) ;
        new Receiver().run(port);
        new Sender().send(port);
    }

    public void run(int port) {    
      try {
        DatagramSocket serverSocket = new DatagramSocket(port);
        byte[] receiveData = new byte[8];

        System.out.printf("Listening on udp:%s:%d%n",
                InetAddress.getLocalHost().getHostAddress(), port);     
        DatagramPacket receivePacket = new DatagramPacket(receiveData,
                           receiveData.length);

        while(true)
        {
              serverSocket.receive(receivePacket);
              String sentence = new String( receivePacket.getData(), 0,
                                 receivePacket.getLength() );
              System.out.println("RECEIVED: " + sentence);
              // now send acknowledgement packet back to sender     
              InetAddress IPAddress = receivePacket.getAddress();
              String sendString = "polo";
              byte[] sendData = sendString.getBytes("UTF-8");
              DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,
                   IPAddress, receivePacket.getPort());
              serverSocket.send(sendPacket);
        }
      } catch (IOException e) {
              System.out.println(e);
      }
      // should close serverSocket in finally block
    }
}
 */

//Another possible code for UDPReceiver










