public class DataAnalysis {
	public String temp;
	public String fire;
	public String smoke;
	static final int tempThreshold = 50;
	public float tempValue;
	public String received;
	
	public DataAnalysis(String received) {
		this.received = received;
		splitString();
	}
	
	public void splitString() {
		String[] split = received.split(":", 3);   //"." is the character at which the string will split. 
		temp = split[0];  //So, there must be 2 full stops to split the string into 3 parts.
		fire = split[1];
		smoke = split[2];
	}
	
	public String getStringTemp() {
		return temp;
	}
	public String getStringFire() {
		return fire;
	}

	public String getStringSmoke() {
		return smoke;
	}
	
	public float getTemp(){
		float tempValue = Float.parseFloat(this.getStringTemp());
		//this.tempValue = tempValue;
		return tempValue;  //Is this the actual temperature value or the voltage value?
	}
	public Boolean isFireDetected() {
		int fireValue = Integer.parseInt(this.getStringFire());
		if(fireValue==1) {
			return false;
		}
		else {
			return true;
		}
	}
	public Boolean isSmokeDetected() {
		//float smokeValue = Float.parseFloat(this.SplitStringSmoke());
		if(gasRatio() < 6.5) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean isTempHigh() {
		if(this.getTemp() > tempThreshold) {
			return true;
		}
		else {
			return false;
		}
	}
	public double gasRatio() {
		float smokeValue = Float.parseFloat(this.getStringSmoke());
		double gasRs = (5.0-smokeValue)/smokeValue;   //Sensing Resistance for the gas detected
		double Ro = 1.74;
		double ratio = gasRs / Ro;
		return ratio;
	}
	
}
