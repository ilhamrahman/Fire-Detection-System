//
//public class Stub extends DataAnalysis {
//	public Stub(String received) {
//		super(received);
//		// TODO Auto-generated constructor stub
//	}
//	//String received = "30:1:1";
//	//@override
//	public String SplitString(String received) {
//		
//		return temp;
//	}
//	public String SplitStringTemp() {
//		DataAnalysis da = new DataAnalysis("30:20:10");
//		String[] split = da.received.split(":", 3);   //"." is the character at which the string will split. 
//		da.temp = split[0];  //So, there must be 2 full stops to split the string into 3 parts.
//		//System.out.println("temp: " + smoke);
//		return da.temp;
//	}
//	public String SplitStringFire() {
//		
//		DataAnalysis da = new DataAnalysis("30:20:10");
//		String[] split = da.received.split(":", 3);   //"." is the character at which the string will split. 
//		da.fire = split[1];  //So, there must be 2 full stops to split the string into 3 parts.
//		//System.out.println("temp: " + smoke);
//		return da.fire;
//	}
//	public String SplitStringSmoke() {
//		
//		DataAnalysis da = new DataAnalysis("30:20:10");
//		String[] split = da.received.split(":", 3);   //"." is the character at which the string will split.  
//		da.smoke = split[2];  //So, there must be 2 full stops to split the string into 3 parts.
//		//System.out.println("temp: " + smoke);
//		return da.smoke;
//	}
//	public float getTemp() {
//		return 60;
//	}
//	public boolean isTempHigh() {
//		if(getTemp() > 50) {
//			return true;
//		}
//		else {
//			return false;
//		}
//		
//	}
//}
