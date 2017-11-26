public class DataAnalysis {
	public String temp;
	public String fire;
	public String smoke;
	static final int tempThreshold = 50;
	public float tempValue;
	public String received;
	
	
	//Constructor takes in the received data string and splits it into 3 parts
	public DataAnalysis(String received) {
		this.received = received;
		splitString();
	}
	
	public void splitString() {
		String[] split = received.split(":", 3);   //":" is the character at which the string will split into an array of 3 elements 
		temp = split[0];  //The first element of the array is the temperature data
		fire = split[1];  //The second element of the array is the fire data
		smoke = split[2]; //The third element of the string is the smoke data 
	}
	
	public String getStringTemp() {
		return temp;  //Return the temperature value as a string
	}
	public String getStringFire() {
		return fire;  //Return the fire data as a string
	}

	public String getStringSmoke() {
		return smoke;  //Return the smoke data as a string
	}
	
	public float getTemp(){
		float tempValue = Float.parseFloat(this.getStringTemp());  //Convert the string temperature value to a float
		return tempValue;  //Return the current temperature value
	}
	public Boolean isFireDetected() {
		int fireValue = Integer.parseInt(this.getStringFire());  //Convert the string fire data into an integer (0 or 1)
		if(fireValue==1) {
			return false;  //If the data received is 1, fire is not detected 
		}
		else {
			return true;  //If the data received is 0, fire is detected
		}
	}
	
	public double gasRatio() {
		float smokeValue = Float.parseFloat(this.getStringSmoke());  //convert string smoke data to a float
		double gasRs = (5.0-smokeValue)/smokeValue;   //Rs is resistance of sensor when exposed to gasses
		double Ro = 1.74;  //Ro is resistance of sensor in clean air
		double ratio = gasRs / Ro;
		return ratio;
	}
	
	public Boolean isSmokeDetected() {
		if(gasRatio() < 6.5) {  //if Rs:Ro is less than 6.5
			return true;  //the gas detected is clean air
		}
		else {
			return false;  //otherwise clean air is detected as the ratio in clean air is 6.5
		}
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
