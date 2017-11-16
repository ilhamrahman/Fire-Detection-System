import java.util.Scanner;

import com.fazecast.jSerialComm.*;

public class Main {

	public static void main(String[] args) {
		
		SerialPort ArPort = SerialPort.getCommPort("COM4");
		//SerialPortEvent Event = new SerialPortEvent(ArPort, 1);
		
		/**
		SerialPort ports[] = SerialPort.getCommPorts();
		System.out.println("Show the ports");
		
		int i = 1;
		for(SerialPort port : ports) {
			System.out.println(i++ + ": " + port.getSystemPortName());
		}
		**/
		if(ArPort.openPort()) {
			ArPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 25, 0);;
			
			Scanner data = new Scanner(ArPort.getInputStream());

			while(data.hasNextLine()) {
				String temp = data.nextLine();
				//Float Temp = Float.valueOf(temp);
				//Temp = (float) ((5.0 * Temp * 100.0)/1024.0);
				System.out.println(temp );
			}
			data.close();
		}
		

	}

}
