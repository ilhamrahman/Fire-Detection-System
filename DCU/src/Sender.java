import org.json.*;

public class Sender {
	JSONObject params;
	
	public Sender() {
		
	}

	public JSONObject SendThis(float Temp, boolean Flame, boolean Smoke) throws JSONException {
		//Get the information that will go through the sender
		params = new JSONObject();
		params.put("Temperature", Temp);
		params.put("Flame", Flame);
		params.put("Smoke", Smoke);
		return params;
		}

}