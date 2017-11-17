import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import com.fazecast.jSerialComm.*;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		DataCollectionClass DataCollection = new DataCollectionClass(); 
		boolean portStatus;
		String Data;
		final String Temp;
		final String Flame;
		final String Smoke;
		
		final float temp;
		final float flame;
		final float smoke;
		
		while(true) {
			portStatus = DataCollection.createPort();
			Data = DataCollection.getValue();
			TimeUnit.SECONDS.sleep(1);
			System.out.println(Data);
			//TimeUnit.SECONDS.sleep(1);
		}
		
		//Flame = DataCollection.ReturnFlame();
		//Smoke = DataCollection.ReturnSmoke();
		
		//temp = DataCollection.GetTempVal();
		//flame = DataCollection.GetFlameVal();
		//smoke = DataCollection.GetSmokeVal();
		
	}

		


	
	

}
