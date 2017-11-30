import java.io.IOException;
import java.net.*;
import org.json.JSONException;
import org.json.JSONObject;


public class Main {

	public static void main(String[] args) throws InterruptedException, JSONException, IOException{
		
		Sender sender = new Sender();
		DataCollectionClass DataCollection = new DataCollectionClass();
		DatagramSocket socket = null;
	      try
	      {
	         // Convert the arguments first, to ensure that they are valid
	         InetAddress host = InetAddress.getByName( args[0] ) ;
	         int port = Integer.parseInt( args[1] ) ;
	         socket = new DatagramSocket() ;
	         
	         DataCollection.createPort();
	         
			 while(true) {
				DataCollection.getValue();
				
				if(DataCollection.CheckData()) {
					DataCollection.SplitData();
					float temp = DataCollection.ReturnTemp();
					boolean flame = DataCollection.ReturnFlame();
					boolean smoke = DataCollection.ReturnSmoke();
					
					JSONObject params = sender.SendThis(temp, flame, smoke);
					byte [] data = params.toString().getBytes();
					DatagramPacket packet = new DatagramPacket(data , data.length, host, port ) ;
					socket.send( packet ) ;
				}
				
			 }
	      }
	      finally
	      {
	         if( socket != null )
	            socket.close() ;
		}
	}
}



