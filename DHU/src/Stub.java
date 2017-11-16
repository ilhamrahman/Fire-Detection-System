
public class Stub extends DataAnalysis {
	String received = "30.20.10";
	
	//@override
	public String SplitStringTemp() {
		
		return "30";
	}
	public String SplitStringFire() {
		return "20";
	}
	public String SplitStringSmoke() {
		return "10";
	}
	public float getTemp() {
		return 30;
	}
	public boolean temperature() {
		if(getTemp() > 50) {
			return true;
		}
		else {
			return false;
		}
		
	}
}
