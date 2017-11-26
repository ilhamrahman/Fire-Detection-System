
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//saves


public class database {

	 Connection conn = null;
	 public Connection connect() {
	        
	        try {

	            String url = "jdbc:sqlite:M:/sql/DHU.db";  		//path to db file
	            conn = DriverManager.getConnection(url);  		//from imports. creates a connection to the DHU	            
	            System.out.println("IT IS LIT BRUV");			//prints it is lit if it connects
	            
	        } catch (SQLException e) {
	        	System.out.println(e.getMessage());				//else if it is null catches it and prints a string of this throwable
	        } finally {
	            try {
	                if (conn != null) {							//if the connection is not null and has passed through above parameters
	                    conn.close();							//close connection
	                }
	            } catch (SQLException ex) {
	            	System.out.println(ex.getMessage());		//exception catch. does not work if the connection is not established
	            }
	        }
	        return conn;
	    }
	 
	 public void createTable() {
		 boolean tableExists;
		 PreparedStatement ptsd = conn.prepareStatement(sql));
	 if (tableExists = false){
	      System.out.println("Table is already created.");
	      }
	      
	      //if table does not exist do this
	      if (tableExists = true){
	    	  String sql = "CREATE TABLE UserInfo " +
	                  "(id TIMESTAMP not NULL, " +
	                  " user_name VARCHAR(255), " + 
	                  " password VARCHAR(255), " + 
	                  " PRIMARY KEY ( id ))"; 

	      ptsd.executeUpdate(sql);
	      System.out.println("Created table in given database...");
	      }
	      
	      
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
		   
		   
	        String sql = "INSERT INTO DHU(Temperature,Fire,Smoke) VALUES(?,?,?)";
	 
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
	 
	    /**
	     * @param args the command line arguments
	     */
	    public static void main(String[] args) {
	        database app = new database();
	        // insert row
	        float a = (float) 1;
	        float b = (float) 69;
	        float c = (float) 96;
	        app.insert(a, true, false);
	        app.insert(b, false, false);
	        app.insert(c, true, true);
	    }

}

