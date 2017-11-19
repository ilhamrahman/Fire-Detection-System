import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import com.fazecast.jSerialComm.SerialPort;

public class DataCollectionClass{
	private boolean openPort;
	SerialPort ArPort = SerialPort.getCommPort("COM4");
	//SerialPortEvent Event = new SerialPortEvent(ArPort, 1);
	
	private String Data;
	private String Temp;
	private String Flame;
	private String Smoke;
	private Scanner data;
	
	protected float temp;
	protected float flame;
	protected float smoke;
	
	public boolean createPort() {		
		openPort = ArPort.openPort(); 
		ArPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);;
		data = new Scanner(ArPort.getInputStream());
		return openPort;
	}
	
	public String getValue(){
		while(data.hasNext()) {
			Data = data.nextLine();
			break;
			//Float Temp = Float.valueOf(temp);
			//Temp = (float) ((5.0 * Temp * 100.0)/1024.0);
			//data.close();
		}
		return Data;
	}
	
	public void SetData() {
		//Take Data and split it into 3 individual strings and set Temp, Flame and Smoke
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
