import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.net.*;
import org.json.JSONObject;

//import com.fazecast.jSerialComm.*;


public class Main {

	public static void main(String[] args) throws InterruptedException{
	    if( args.length != 2 )
	    {
	       System.out.println( "usage: java UDPSender host port" ) ;
	       return ;
	    }
		Sender sender = new Sender();
		DataCollectionClass DataCollection = new DataCollectionClass();
		DatagramSocket socket = null ;
	      try
	      {
	         // Convert the arguments first, to ensure that they are valid
	         InetAddress host = InetAddress.getByName( args[0] ) ;
	         int port = Integer.parseInt( args[1] ) ;
	         socket = new DatagramSocket() ;
   
	         
			 while(true) {
			    @SuppressWarnings("unused")
				boolean portStatus = DataCollection.createPort();
				
				DataCollection.SplitData();
				float temp = DataCollection.ReturnTemp();
				boolean flame = DataCollection.ReturnFlame();
				float smoke = DataCollection.ReturnSmoke();
				TimeUnit.SECONDS.sleep(1);
				
				JSONObject params = sender.SendThis(temp, flame, smoke);
				byte [] data = params.toString().getBytes();
				DatagramPacket packet = new DatagramPacket(data , data.length, host, port ) ;
				socket.send( packet ) ;
			 }
	      }
		  catch( Exception e )
	      {
	         System.out.println( e ) ;
	      }
	      finally
	      {
	         if( socket != null )
	            socket.close() ;
		}
	}
}
