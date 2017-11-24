
public class DataAnalysis extends Receiver {
	public String temp;
	public String fire;
	public String smoke;
	static final int tempThreshold = 50;
	public float tempValue;
	public String received;
	
	public String SplitStringTemp() {
		//String received = Receiver.(whatever is received in receiver class from DCU)
		//received = "30:20:10";
		String[] split = received.split(":", 3);   //"." is the character at which the string will split. 
		String temp = split[0];  //So, there must be 2 full stops to split the string into 3 parts.
		String fire = split[1];
		String smoke = split[2];
		//System.out.println("temp: " + smoke);
		return temp;
	}
	public String SplitStringFire() {
		//String received = Receiver.(whatever is received in receiver class from DCU)
		//received = "30:20:10";
		String[] split = received.split(":", 3);   //"." is the character at which the string will split. 
		String temp = split[0];  //So, there must be 2 full stops to split the string into 3 parts.
		String fire = split[1];
		String smoke = split[2];
		//System.out.println("temp: " + smoke);
		return fire;
	}

	public String SplitStringSmoke() {
		//String received = Receiver.(whatever is received in receiver class from DCU)
		//received = "30:20:10";
		String[] split = received.split(":", 3);   //"." is the character at which the string will split. 
		String temp = split[0];  //So, there must be 2 full stops to split the string into 3 parts.
		String fire = split[1];
		String smoke = split[2];
		//System.out.println("temp: " + smoke);
		return smoke;
	}
	
	public float getTemp(){
		float tempValue = Float.parseFloat(this.SplitStringTemp());
		//this.tempValue = tempValue;
		return tempValue;  //Is this the actual temperature value or the voltage value?
	}
	public Boolean isFireDetected() {
		int fireValue = Integer.parseInt(this.SplitStringFire());
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
		float smokeValue = Float.parseFloat(this.SplitStringSmoke());
		double gasRs = (5.0-smokeValue)/smokeValue;   //Sensing Resistance for the gas detected
		double Ro = 0.33;
		double ratio = gasRs / Ro;
		return ratio;
	}
	
}
