package connection_object;

import java.sql.SQLException;

public class App {

	public App() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		System.out.println("Test Progress Db connection"); 
        OpenEdge_Connection oedbc = new OpenEdge_Connection();
        try {
			oedbc.connect_db();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}

}
