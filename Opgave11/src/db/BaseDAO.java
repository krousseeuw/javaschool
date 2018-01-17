package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class BaseDAO {
	private Connection connection;
	protected final String defaultErrorMessage = "error unexpected";

	
	public Connection getConnection() {
		return connection;
	}
	
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	public BaseDAO() {
		try {
			setConnection(DatabaseSingleton.getDatabaseSingleton().getConnection(true));
			
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}