import java.util.Scanner;
import com.fazecast.jSerialComm.*;

import com.fazecast.jSerialComm.SerialPort;

public class DataCollectionClass{
	protected boolean openPort;
	SerialPort ArPort = SerialPort.getCommPort("COM4");
	
	private String Data;
	protected String Temp;
	private String Flame;
	private String Smoke;
	
	protected float temp;
	protected float flame;
	protected float smoke;
	
	
	public boolean createPort() {		
		openPort = ArPort.openPort(); 
		ArPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);;
		return openPort;
	}
	
	public String getValue(){
		Scanner data = new Scanner(ArPort.getInputStream());

		Data = data.nextLine();
		//Float Temp = Float.valueOf(temp);
		//Temp = (float) ((5.0 * Temp * 100.0)/1024.0);
		data.close();
		return Data;
	}
	
	public void SetData() {
		
	}
	
	public String ReturnTemp() {
		return Temp;
	}
	
	public String ReturnFlame() {
		return Flame;
	}
	
	public String ReturnSmoke() {
		return Smoke;
	}
	
	public float GetTempVal() {
		temp = Float.parseFloat(Temp);
		temp = (float) ((5.0 * temp * 100.0)/1024.0); 
		return temp;
	}
	
	public float GetFlameVal() {
		flame = Float.parseFloat(Flame);
		flame = (float) ((5.0 * temp * 100.0)/1024.0); //change
		return flame;
	}
	
	public float GetSmokeVal() {
		smoke = Float.parseFloat(Smoke);
		smoke = (float) ((5.0 * temp * 100.0)/1024.0); //change
		return smoke;
	}
	
}
