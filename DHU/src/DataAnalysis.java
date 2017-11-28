import org.json.*;

public class DataAnalysis {
	
	public boolean isFire;
	public boolean isSmoke;
	static final int tempThreshold = 50;
	public float tempValue;
	public String received;
	public JSONObject jsonReceived;
	
	
	//Constructor takes in the received data string and splits it into 3 parts
	public DataAnalysis(String received) {
		this.received = received;
		try {
			jsonReceived  = new JSONObject(received);
		} catch (JSONException e) {
			e.printStackTrace();
		} 
	}
	/**
	public void splitString() {
		String[] split = received.split(":", 3);   //":" is the character at which the string will split into an array of 3 elements 
		temp = split[0];  //The first element of the array is the temperature data
		fire = split[1];  //The second element of the array is the fire data
		smoke = split[2]; //The third element of the string is the smoke data 
	}
	*/

	public float getTemp(){
		try {
			tempValue = (float)jsonReceived.getDouble("Temperature");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempValue;
	}
	
	public Boolean isFireDetected() {
		try {
			isFire = jsonReceived.getBoolean("Flame");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isFire;
	}
	
	// TODO Figure out what's happening here
	/** public double gasRatio() {
		float smokeValue = Float.parseFloat(this.getStringSmoke());  //convert string smoke data to a float
		double gasRs = (5.0-smokeValue)/smokeValue;   //Rs is resistance of sensor when exposed to gasses
		double Ro = 1.74;  //Ro is resistance of sensor in clean air
		double ratio = gasRs / Ro;
		return ratio;
	}
	*/
	
	public Boolean isSmokeDetected() {
		try {
			isSmoke = jsonReceived.getBoolean("Flame");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSmoke;
	}
	
	public boolean isTempHigh() {
		if(this.getTemp() > tempThreshold) {
			return true;  //return true if the current temperature is higher than the set threshold temperature
		}
		else {
			return false;
		}
	}

	
}