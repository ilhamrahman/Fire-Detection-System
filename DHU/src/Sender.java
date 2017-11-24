import java.net.*;
import java.util.Scanner;
import org.json.*;
import java.util.concurrent.TimeUnit;
public class Sender {
	
public String tempMessage(boolean isTempHigh) {
		
		String TempLow = "RELAX! The current temperature is below the dangerous threshold temperature.";
		String TempHigh = "DANGER! The current temperature is above the dangerous threshold temperature.";
		
		if (isTempHigh){
			return TempHigh; 
		}
		else {
			return TempLow;
		}
	}
	public String fireMessage(boolean isFireDetected) {

		String noFire = "RELAX! There is no danger of fire in your house.";
		String yesFire = "DANGER! Fire was detected in your house!";
		
		if (isFireDetected){  //if value received is 0, fire is detected
			return yesFire;
		}
		else {
			return noFire;
		}
	}
	
	public String smokeMessage(boolean isSmokeDetected) {
		String noSmoke = "RELAX! There is no danger of smoke in your house.";
		String yesSmoke = "DANGER! Smoke was detected in your house!";
		
		if (isSmokeDetected){
			return yesSmoke;
		}
		else {
			return noSmoke;
		}
	}
	public JSONObject send(float Temp, String tempMessage, String fireMessage, String smokeMessage) throws JSONException {
		
	    JSONObject params = new JSONObject();
	    System.out.println("Sending the analyzed data from the Data Handling Unit to the Android Application... ");

	    params.put("Current Temperature Value: ", Temp);
	    params.put("Temperature Status: ", tempMessage);
	    params.put("Fire Status: ", fireMessage);
	    params.put("Smoke Status: ", smokeMessage); 
	    return params;  
	}
	
}
