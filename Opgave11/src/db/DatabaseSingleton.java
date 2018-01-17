package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



// GEBRUIKT OOK BIBLIOTHEEK

public class DatabaseSingleton {
	private static DatabaseSingleton ref;
	
	private Connection connection;
	
	public DatabaseSingleton() {
		try {
			Class.forName("com.mysql.jdbc.Driver");			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static DatabaseSingleton getDatabaseSingleton() {
		if(ref==null)
			ref = new DatabaseSingleton();
		return ref;
	}
	
	public Object clone() throws CloneNotSupportedException{
		throw new CloneNotSupportedException();
	}
	
	public Connection getConnection(boolean b) throws SQLException {
		if(connection==null||connection.isClosed()) {
			try {
				connection = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/bibliotheek_ehb?verifyServerCertificate=false&useSSL=true", 
						DatabaseProperties.USERNAME, 
						DatabaseProperties.PASSWORD);
			} catch (SQLException ex) {
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());
			}
		}
		return connection;
	}
}