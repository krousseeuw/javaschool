package oefening3.db;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseSingleton {
	private static DatabaseSingleton ref;
	
	public DatabaseSingleton() {
		try {
			Class.forName("com.mysql.jdbc.Driver");			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static DatabaseSingleton getDatabaseSingleton() {
		// TODO Auto-generated method stub
		return null;
	}

	public Connection getConnection(boolean b) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
