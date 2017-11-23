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
	      Sender sender = new Sender();
	      DataAnalysis data = new DataAnalysis();
	      
	      try
	      {
	         // Convert the argument to ensure that is it valid
	         int port = Integer.parseInt( args[1] ) ;
	         InetAddress host = InetAddress.getByName( args[0] ) ;
	         socket = new DatagramSocket() ;

	         // Construct the socket
	         //DatagramSocket socket = new DatagramSocket( port ) ;
	         
	         for( ;; )
	         {
		        System.out.println( "Receiving on port " + port ) ;
		        DatagramPacket packet = new DatagramPacket( new byte[PACKETSIZE], PACKETSIZE ) ;
	            socket.receive( packet ) ;
	          
	            
	            float temp = data.getTemp();
	            String tempMessage = sender.tempMessage();
	            String fireMessage = sender.fireMessage();
	            String smokeMessage = sender.smokeMessage();
	 
	          System.out.println( packet.getAddress() + " " + packet.getPort() + ": " + new String(packet.getData()).trim() ) ;
	          new Sender().send(temp, tempMessage, fireMessage, smokeMessage);
	         
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










