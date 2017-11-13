
public class DataAnalysis extends Receiver {
	public String temp;
	public String fire;
	public String smoke;
	static final int tempThreshold = 50;
	public float tempValue;
	public int n;
	public String SplitStringTemp() {
		//String received = Receiver.(whatever is received in receiver class from DCU)
		String received = "30:20:10";
		String[] split = received.split(":", 3);   //"." is the character at which the string will split. 
		String temp = split[0];  //So, there must be 2 full stops to split the string into 3 parts.
		String fire = split[1];
		String smoke = split[2];
		//System.out.println("temp: " + smoke);
		return temp;
	}
	public String SplitStringFire() {
		//String received = Receiver.(whatever is received in receiver class from DCU)
		String received = "30:20:10";
		String[] split = received.split(":", 3);   //"." is the character at which the string will split. 
		String temp = split[0];  //So, there must be 2 full stops to split the string into 3 parts.
		String fire = split[1];
		String smoke = split[2];
		//System.out.println("temp: " + smoke);
		return fire;
	}
	public String SplitStringSmoke() {
		//String received = Receiver.(whatever is received in receiver class from DCU)
		String received = "30:20:10";
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
	public float getFire() {
		float fireValue = Float.parseFloat(this.SplitStringFire());
		return fireValue;   //Voltage value through flame sensor
	}
	public float getSmoke() {
		float smokeValue = Float.parseFloat(SplitStringSmoke());
		return smokeValue;
	}
	public boolean temperature() {
		if(this.getTemp() > tempThreshold) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
