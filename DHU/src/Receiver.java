//import java.io.IOException;
import java.net.*;
//import org.json.*;

//import java.net.*;
//import java.util.Arrays;

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
	             Database db = new Database();
	             
	             //insert received data into database
	             db.insert(data.getTemp(), data.isFireDetected(), data.isSmokeDetected());
	             
	             Sender sender = new Sender();     //initialize sender

	  
	          
	             sender.send(db);     //send the data to the android application
	            
	         
	         }
	         
	     }
	     catch( Exception e )
	     {
	        System.out.println( e ) ;
	     }
	     
	     
}
}













