
import org.json.*;

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
		
		if (isFireDetected){  //if fire is detected
			return yesFire;   //send warning message
		}
		else {
			return noFire;  //otherwise send relax message
		}
	}
	
	public String smokeMessage(boolean isSmokeDetected) {
		String noSmoke = "RELAX! There is no danger of smoke in your house.";
		String yesSmoke = "DANGER! Smoke was detected in your house!";
		
		if (isSmokeDetected){ //if smoke is detected
			return yesSmoke;  //send warning message
		}
		else {
			return noSmoke;   //otherwise send relax message
		}
	}
	public JSONObject send() throws JSONException {
		
	    JSONObject params = new JSONObject();   //initialize JSONObject data to be sent
	    System.out.println("Sending the analyzed data from the Data Handling Unit to the Android Application... ");
	    Database db = new Database();

	    //params.put("Current Temperature Value: ", Temp);   //add current temperature value on data to be sent 
	    //params.put("Temperature Status: ", tempMessage);   //let the app know if the temperature is higher or lower than threshold
	    //params.put("Fire Status: ", fireMessage);   //add fire status on data to be sent 
	    //params.put("Smoke Status: ", smokeMessage);  //add smoke status on data to be sent
	    
	    params.put("Latest Entry: ", db.retrieveLastEntry());
	    
	    return params;     //return data that is to be sent to the android application
	}
	
}
