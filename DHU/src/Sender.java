import java.net.*;
import java.util.Scanner;
import org.json.*;
import java.util.concurrent.TimeUnit;
public class Sender extends Receiver {
	
public String tempMessage() {
		
		DataAnalysis d = new DataAnalysis();
		String TempLow = "RELAX! The current temperature is below the dangerous threshold temperature.";
		String TempHigh = "DANGER! The current temperature is above the dangerous threshold temperature.";
		
		if (d.isTempHigh() == true){
			return TempHigh; 
		}
		else {
			return TempLow;
		}
	}
	public String fireMessage() {
		DataAnalysis d = new DataAnalysis();
		
		String noFire = "RELAX! There is no danger of fire in your house.";
		String yesFire = "DANGER! Fire was detected in your house!";
		
		if (d.isFireDetected() == true){  //if value received is 0, fire is detected
			return yesFire;
		}
		else {
			return noFire;
		}
	}
	
	public String smokeMessage() {
		
		DataAnalysis d = new DataAnalysis();
		String noSmoke = "RELAX! There is no danger of smoke in your house.";
		String yesSmoke = "DANGER! Smoke was detected in your house!";
		
		if (d.isSmokeDetected() == true){
			return yesSmoke;
		}
		else {
			return noSmoke;
		}
	}
	public JSONObject send(float Temp, String tempMessage, String fireMessage, String smokeMessage) throws JSONException 
	   {	 // boolean firestatus = false;
	   		  //Integer temperature;
	   		  //Integer pressure;
	   		  JSONObject params = new JSONObject();
	   		  
	   
		      // Check the arguments
		      //if( args.length != 2 )
		      //{
		        // System.out.println( "usage: java UDPSender host port" ) ;
		         //return ;
		      //}
		   
		     // try
		    //  {
		         // Convert the arguments first, to ensure that they are valid
		         //InetAddress host = InetAddress.getByName(args[0]) ;  
		        // int port         = Integer.parseInt( args[1] ) ;
		         
	     
		         //Scanner in;
		         //in = new Scanner (System.in);
		         //String message = null;
		         while (true)
		         {
		        	     //These are the inputs The sender will idealy get from the sensors. 
		        	     //
		        		 //System.out.println("Press ENTER if a fire is present. Else type a string");
		        		 //message = this.tempMessage();
		        		/* if (message.length()==0) firestatus = true;
		        		 
		        		 System.out.println("Enter the Current Temperature");
		        		 message = in.nextLine();
		        		 temperature = Integer.parseInt(message);
		        		 
		        		 System.out.println("Enter the Current Pressure");
		        		 message = in.nextLine();
		        		 pressure = Integer.parseInt(message);
		        		 */
		        	 
		        	     System.out.println("Sending the analyzed data from the Data Handling Unit to the Android Application... ");
		        	     
		        	     DataAnalysis da = new DataAnalysis();
		        	     //float tempV = da.getTemp();

		        	     params.put("Current Temperature Value: ", Temp);
		        		 params.put("Temperature Status: ", tempMessage);
		        		 params.put("Fire Status: ", fireMessage);
		        		 params.put("Smoke Status: ", smokeMessage);
		        		 
		        		 
		        		 return params;  
		        		 
		        		 /*byte [] data = params.toString().getBytes();
		        		 DatagramPacket packet = new DatagramPacket(data , data.length, host, port ) ;
		        		 TimeUnit.SECONDS.sleep(3);
		        		 socket.send( packet ) ;*/
		        		 
		        		// System.out.println("Press ENTER to exit");
		        		 //message = in.nextLine();
		        		 //if (message.length()==0) break;
		         } 
		         
		         //System.out.println ("Closing down");
		      //}
		      /*catch( Exception e )
		      {
		         System.out.println( e ) ;
		      }
		      finally
		      {
		         if( socket != null )
		            socket.close() ;
	      }*/
		        
	   }
	/*
	public static void main(String[] args) 
	   {	 // boolean firestatus = false;
	   		  //Integer temperature;
	   		  //Integer pressure;
	   		  JSONObject params = new JSONObject();
	   		  
	   
		      // Check the arguments
		      if( args.length != 2 )
		      {
		         System.out.println( "usage: java UDPSender host port" ) ;
		         return ;
		      }
		      DatagramSocket socket = null ;
		      try
		      {
		         // Convert the arguments first, to ensure that they are valid
		         InetAddress host = InetAddress.getByName( args[0] ) ;
		         int port         = Integer.parseInt( args[1] ) ;
		         socket = new DatagramSocket() ;
	     
		         //Scanner in;
		         //in = new Scanner (System.in);
		         //String message = null;
		         while (true)
		         {
		        	     //These are the inputs The sender will idealy get from the sensors. 
		        	     //
		        		 //System.out.println("Press ENTER if a fire is present. Else type a string");
		        		 //message = this.tempMessage();
		        		//if (message.length()==0) firestatus = true;
		        		 
		        		// System.out.println("Enter the Current Temperature");
		        		 //message = in.nextLine();
		        		// temperature = Integer.parseInt(message);
		        		 
		        		// System.out.println("Enter the Current Pressure");
		        		// message = in.nextLine();
		        		// pressure = Integer.parseInt(message);
		        		 
		        	 
		        	     System.out.println("Sending the analyzed data from the Data Handling Unit to the Android Application... ");
		        	     
		        	     DataAnalysis da = new DataAnalysis();
		        	     float tempV = da.getTemp();

		        	     params.put("Current Temperature Value: ", tempV);
		        		 params.put("Temperature Status: ", tempMessage());
		        		 params.put("Fire Status: ", fireMessage());
		        		 params.put("Smoke Status: ", smokeMessage());
		        		 
		        		 byte [] data = params.toString().getBytes();
		        		 DatagramPacket packet = new DatagramPacket(data , data.length, host, port ) ;
		        		 socket.send( packet ) ;
		        		 
		        		// System.out.println("Press ENTER to exit");
		        		 //message = in.nextLine();
		        		 //if (message.length()==0) break;
		         } 
		         //System.out.println ("Closing down");
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
	   */
	
}
