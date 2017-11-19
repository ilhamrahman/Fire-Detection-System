import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import com.fazecast.jSerialComm.SerialPort;

public class DataCollectionClass{
	private boolean openPort;
	SerialPort ArPort = SerialPort.getCommPort("COM4");
	//SerialPortEvent Event = new SerialPortEvent(ArPort, 1);
	
	protected String Data;
	protected String Temp;
	protected String Flame;
	protected String Smoke;
	protected Scanner data;
	protected boolean status;
	
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
		status = data.hasNext();
		while(status) {
			Data = data.nextLine();
			break;
			//Float Temp = Float.valueOf(temp);
			//Temp = (float) ((5.0 * Temp * 100.0)/1024.0);
			//data.close();
		}
		return Data;
	}
	
	public String ReturnTemp() {
		//Data = "30:20:10";
		String[] split = Data.split(":", 3);   //"." is the character at which the string will split. 
		Temp = split[0];  //So, there must be 2 full stops to split the string into 3 parts.
		Flame = split[1];
		Smoke = split[2];
		//System.out.println("temp: " + smoke);
		return Temp;
	}
	
	public String ReturnFlame() {
		//Data = "30:20:10";
		String[] split = Data.split(":", 3);   //"." is the character at which the string will split. 
		Temp = split[0];  //So, there must be 2 full stops to split the string into 3 parts.
		Flame = split[1];
		Smoke = split[2];
		//System.out.println("temp: " + smoke);
		return Flame;
	}
	
	public String ReturnSmoke() {
		//Data = "30:20:10";
		String[] split = Data.split(":", 3);   //"." is the character at which the string will split. 
		Temp = split[0];  //So, there must be 2 full stops to split the string into 3 parts.
		Flame = split[1];
		Smoke = split[2];
		//System.out.println("temp: " + smoke);
		return Smoke;
	}
	
	public float GetTempVal() {
		temp = Float.parseFloat(Temp);
		temp = (float) ((5.0 * temp * 100.0)/1024.0); 
		return temp;
	}

	public float GetSmokeVal() {
		smoke = Float.parseFloat(Smoke);
		smoke = (float) ((5.0 * temp * 100.0)/1024.0); //change
		return smoke;
	}
	
}