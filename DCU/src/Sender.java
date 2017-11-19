import java.net.*;
import java.util.Scanner;
import org.json.*;

public class Sender {
	boolean firestatus = false;
	Integer temperature;
	Integer pressure;
	JSONObject params = new JSONObject();

	public JSONObject SendThis(float Temp, boolean Flame, float Smoke) throws JSONException {
		//Get the information that will go through the sender
		params.put("Temperature", Temp);
		params.put("Flame", Flame);
		params.put("Smoke", Smoke);
		return params;
		}

}
