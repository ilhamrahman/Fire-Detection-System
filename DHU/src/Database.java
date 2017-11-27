import java.awt.Cursor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//SQLite Database created on command prompt. code is as follows

/*M:\sql>sqlite3 DHU                                                              //Database created here
SQLite version 3.21.0 2017-10-24 18:55:49
Enter ".help" for usage hints.
sqlite> create table DHU_Database(ID INTEGER PRIMARY KEY AUTOINCREMENT, Temperature Float, Fire INTEGER, Smoke INTEGER, Time DATETIME DEFAULT(STRFTIME('%d-%m-%Y  %H:%M', 'NOW', 'localtime'))); //Table created here
sqlite> INSERT INTO DHU_Database(Temperature, Fire, Smoke) VALUES (24.0,0,0);	  //Inserting fake values to check if the database and table is active
sqlite> INSERT INTO DHU_Database(Temperature, Fire, Smoke) VALUES (23.0,1,1);
sqlite> INSERT INTO DHU_Database(Temperature, Fire, Smoke) VALUES (20.0,1,0);
sqlite> SELECT*FROM DHU_Database												  //Prints the specified table present in the database
   ...> ;
1|24.0|0|0|27-11-2017  12:58
2|23.0|1|1|27-11-2017  12:59
3|20.0|1|0|27-11-2017  12:59
sqlite>
*/

public class Database {
	

	public Connection connect() {
		Connection conn = null;
		String url = "jdbc:sqlite:M://sql/Database.db";		//path to db file
	    try {
	    	conn = DriverManager.getConnection(url);  		//from imports. creates a connection to the DHU	            
	    } catch (SQLException e) {
	    	System.out.println(e.getMessage());				//else if it is null/not a valid path catches it and prints a string of this throwable
	    	}
	    return conn;
	    }
	 
	public void insert(float Temperature, boolean Fire, boolean Smoke) {
		int fire, smoke;

		if (Fire == true) {									//since DHU unit passes boolean values and the database uses
			fire = 1;										//integers, this simple loop assigns a 1 if true else assigns false. 
		} else {											//This is for Fire and Smoke values only
		   fire = 0;
		}
		
		if (Smoke == true) {
			smoke = 1;
		} else {
			smoke = 0;
		   }
		
		String sql = "INSERT INTO DHU_Database(Temperature,Fire,Smoke) VALUES(?,?,?)";   //creates a insert method to accept data in
	 
	        try (Connection conn = this.connect();
	            PreparedStatement ptsd = conn.prepareStatement(sql)) {					//Validates connection to put desired string in database
	            ptsd.setFloat(1, Temperature);											//assigns first entry for Temperature	
	            ptsd.setInt(2, fire);													//assigns second entry for fire
	            ptsd.setInt(3, smoke);													//assigns third entry for smoke
	            ptsd.executeUpdate();													//updates table here
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());										//catches any exceptions that is not accounted for (invalid inputs)
	        }
	    }
	 	
	
	public void getFire(boolean Fire){
		int fire;
		if (Fire = true) {
			fire = 0;
		} else {
			fire = -1;
		}
		
		String sql = "SELECT ID, Temperature, Fire, Smoke "								//sql query to select an entry
                       + "FROM DHU_Database WHERE Fire > ?";
            
		try (Connection conn = this.connect();
				PreparedStatement ptsd  = conn.prepareStatement(sql)){					//validates connection
			ptsd.setInt(1,fire);														//sets the value 
			ResultSet rs  = ptsd.executeQuery();										//Executes query
         
			while (rs.next()) {															//while loop through loop through database and 
				System.out.println(rs.getInt("ID") +  "\t" + 							//get all results where fire entry is true
            		 			rs.getFloat("Temperature") + "\t" +
                                rs.getInt("Fire") + "\t" +
                                rs.getInt("Smoke"));
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());										//catches any exceptions
				}
		}
	
	public void getSmoke(boolean Smoke){
		int smoke;
		if(Smoke = true) {
			smoke = 0;
		} else {
			smoke = -1;
		}
		
		String sql = "SELECT ID, Temperature, Fire, Smoke "								//sql query to select an entry
                       + "FROM DHU_Database WHERE Fire > ?";
            
		try (Connection conn = this.connect();
				PreparedStatement ptsd  = conn.prepareStatement(sql)){					//validates connection
			ptsd.setInt(1,smoke);														//sets the value 
			ResultSet rs  = ptsd.executeQuery();										//Executes query
         
			while (rs.next()) {															//while loop through loop through database and 
				if (rs.next() == true) {
				System.out.println(rs.getInt("ID") +  "\t" + 							//get all results where fire entry is true
            		 			rs.getFloat("Temperature") + "\t" +
                                rs.getInt("Fire") + "\t" +
                                rs.getInt("Smoke"));
				}
		}
			} catch (SQLException e) {
				System.out.println(e.getMessage());										//catches any exceptions
				}
		}
	

}