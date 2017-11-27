import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

public class database {


	 public Connection connect() throws SQLException {
		 Connection conn = null;
		 String url = "jdbc:sqlite:M://sql/Database.db";//path to db file
	        
	            conn = DriverManager.getConnection(url);  		//from imports. creates a connection to the DHU	            
	       /* } catch (SQLException e) {
	        	System.out.println(e.getMessage());				//else if it is null catches it and prints a string of this throwable
	        }*/
	        return conn;
	    }
	 
	 	public void insert(float Temperature, boolean Fire, boolean Smoke) {
		  int fire, smoke;
		   
		   if (Fire == true) {
			   fire = 1;
		   } else {
			   fire = 0;
		   }
		   
		   if (Smoke == true) {
			   smoke = 1;
		   } else {
			   smoke = 0;
		   }
		  
		   
	        String sql = "INSERT INTO DHU_Database(Temperature,Fire,Smoke) VALUES(?,?,?)";
	 
	        try (Connection conn = this.connect();
	            PreparedStatement ptsd = conn.prepareStatement(sql)) {
	            ptsd.setFloat(1, Temperature);
	            ptsd.setInt(2, fire);
	            ptsd.setInt(3, smoke);
	            ptsd.executeUpdate();
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	    }

	 
	    public static void main(String[] args) {
	        database x = new database();
	        // insert row
	        float a = (float) 1;
	        float b = (float) 12;
	        float c = (float) 96;
	        x.insert(a, true, false);
	        x.insert(b, true, true);
	        x.insert(c, false , true);
	    }
	
}
