
public class Stub extends DataCollectionClass {
	
	public boolean createPort() {
		return true;
	}
	
	public String getValue(){
		status = true;
		if (status == false){
			Data = "";
		}
		else
			Data = "aaaa";
		return Data;
	}
	
	public String ReturnTemp() {
		
		Data = "30:20:10";
		String[] split = Data.split(":", 3);   //"." is the character at which the string will split. 
		Temp = split[0];  //So, there must be 2 full stops to split the string into 3 parts.
		//System.out.println("temp: " + smoke);
		return Temp;
	}
	public String ReturnFlame() {
		
		Data = "30:20:10";
		String[] split = Data.split(":", 3);   //"." is the character at which the string will split. 
		Flame = split[1];  //So, there must be 2 full stops to split the string into 3 parts.
		//System.out.println("temp: " + smoke);
		return Flame;
	}
public String ReturnSmoke() {
		
		Data = "30:20:10";
		String[] split = Data.split(":", 3);   //"." is the character at which the string will split. 
		Smoke = split[2];  //So, there must be 2 full stops to split the string into 3 parts.
		//System.out.println("temp: " + smoke);
		return Smoke;
	}
	
	public float getTempVal() {
		return temp = (float) 30;
	}
	



}
