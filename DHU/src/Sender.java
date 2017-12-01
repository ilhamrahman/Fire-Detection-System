import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import org.json.*;

public class Sender {
	
	public static Socket s;
    public static ServerSocket ss;
    public static InputStreamReader isr;
    public static BufferedReader bufferedReader;
    public static String message;
    
	public void send(Database db)  {
		Database database = db;
		
		try {
			@SuppressWarnings("resource")
			Socket s = new Socket("10.0.0.100", 6000);
			PrintWriter pw = new PrintWriter(s.getOutputStream());
			pw.write(database.retrieveLastEntry());
			pw.flush();
			pw.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
}
