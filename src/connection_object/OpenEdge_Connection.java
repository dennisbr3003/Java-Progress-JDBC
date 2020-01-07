package connection_object;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OpenEdge_Connection {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.ddtek.jdbc.openedge.OpenEdgeDriver";
	static final String DB_URL = "jdbc:datadirect:openedge://localhost:20600;databaseName=MediaIndex"; //<-- service port or name (use -1 as portnumber) could also be ODBC port

	// Database credentials (should be a parameter retrieved from user)
	static final String USER = "PUB";
	static final String PASS = "PUB";

	Statement stmt = null;
	Connection con = null;

	public OpenEdge_Connection() {
		// TODO Auto-generated constructor stub
	}

	public String connect_db() throws SQLException  {
		try {
			// Register the driver with the driver manager.
			// If using Java SE 6 or higher, you can omit this step. 
			// Java SE 6 and higher automatically registers the driver. 
			// Still a good check weather the JAR is included or not
			try {
				Class.forName(JDBC_DRIVER);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			// Establish the Connection
			//String url = "jdbc:datadirect:openedge://localhost:20500;DatabaseName=Media2015";
			con = DriverManager.getConnection(DB_URL, USER, PASS);

			// Verify the Connection
			DatabaseMetaData metaData = con.getMetaData();
			System.out.println("Database Name: " + metaData.getDatabaseProductName());
			System.out.println("Database Version: " + metaData.getDatabaseProductVersion());		

			System.out.println("Creating statement...");
			stmt = con.createStatement();
			String sql;
			sql = "SELECT * FROM PUB.CollectionIndex";
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()){

				//Retrieve by column name
				int id = rs.getInt("iCollectionNumber");
				//String last = rs.getString("cCollectionName");

				//Display values
				//System.out.println("Key: " + id);
				//System.out.println(", cFileName: " + last);
			}

			System.out.println("Done");

			//STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			con.close();	    


			return "success2";
		}
		finally {
			try{
				if(stmt!=null)
					stmt.close();
			} 
			catch(SQLException se2){
			}// nothing can be done
			try{
				if(con!=null)
					con.close();		
			} catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public chunk connect_db(chunk c) throws SQLException  {
		try {
			// Register the driver with the driver manager.
			// If using Java SE 6 or higher, you can omit this step. 
			// Java SE 6 and higher automatically registers the driver. 
			// Still a good check weather the JAR is included or not
			int i = 0; 
			try {
				Class.forName(JDBC_DRIVER);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			// Establish the Connection
			//String url = "jdbc:datadirect:openedge://localhost:20500;DatabaseName=Media2015";
			con = DriverManager.getConnection(DB_URL, USER, PASS);

			// Verify the Connection
			DatabaseMetaData metaData = con.getMetaData();
			System.out.println("Database Name: " + metaData.getDatabaseProductName());
			System.out.println("Database Version: " + metaData.getDatabaseProductVersion());		

			System.out.println("Creating statement...");
			stmt = con.createStatement();
			String sql;
			sql = "SELECT * FROM PUB.CollectionIndex";
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()){

				//Retrieve by column name
				int id = rs.getInt("iCollectionNumber");
				i++;
				//String last = rs.getString("cCollectionName");

				//Display values
				//System.out.println("Key: " + id);
				//System.out.println(", cFileName: " + last);
			}

			System.out.println("Done");

			//STEP 6: Clean-up environment
			
			c.setNumber_of_records(i);
		    c.setInstance_code(this.toString());	
		    c.setCall_object_hashcode(this.hashCode());
		    
			rs.close();
			stmt.close();
			con.close();	    

            c.setCall_success("success"); 
			
		}
		finally {
			try{
				if(stmt!=null)
					stmt.close();
			} 
			catch(SQLException se2){
			}// nothing can be done
			try{
				if(con!=null)
					con.close();		
			} catch(Exception e){
				e.printStackTrace();
			}
		}
		return c;
	}	
	
}