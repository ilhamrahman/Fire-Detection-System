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
	      if( args.length != 2 )
	      {
	         System.out.println( "usage: UDPReceiver port" ) ;
	         return ;
	      }
	      
	      DatagramSocket socket = null ;
	      
	      try
	      {
	         // Convert the argument to ensure that is it valid
	         int port = Integer.parseInt( args[1] ) ;
	         InetAddress host = InetAddress.getByName( args[0] ) ;
	         socket = new DatagramSocket(port) ;

	         // Construct the socket
	         //DatagramSocket socket = new DatagramSocket( port ) ;
	         
	         for( ;; )
	         {
		         DatagramPacket packet = new DatagramPacket( new byte[PACKETSIZE], PACKETSIZE ) ;
	             socket.receive( packet ) ;
	             String DataReceived = new String(packet.getData()).trim();
	             DataAnalysis data = new DataAnalysis(DataReceived);
	             
	             Sender sender = new Sender();   
	             float temp = data.getTemp();
	             String tempMessage = sender.tempMessage(data.isTempHigh());
	             String fireMessage = sender.fireMessage(data.isFireDetected());
	             String smokeMessage = sender.smokeMessage(data.isSmokeDetected());
	  
	          
	             sender.send(temp, tempMessage, fireMessage, smokeMessage);
	         
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










