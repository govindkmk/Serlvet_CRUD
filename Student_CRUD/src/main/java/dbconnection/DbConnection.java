package dbconnection;

import java.sql.*;

public class DbConnection {

	private DbConnection() {
    }
    
    private static Connection connection = null;
    
	public static Connection getConnection() throws SQLException {
		
		
		try {
			if(connection == null) {
			Class.forName("com.mysql.jdbc.Driver");
			
			connection =  DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/student_db", "root", "root");
			System.out.println("Connection Created Successfully...");
			
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return connection;
	
	}
	

	public static void main(String[] args) throws SQLException {
		DbConnection.getConnection();
	}
}
