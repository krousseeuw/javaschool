package oefening3.db;

import java.sql.Connection;
import java.sql.SQLException;

public class BaseDAO {
	private Connection connection;
	
	protected Connection getConnection() {
		return connection;
	}
	
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public BaseDAO() {
		try {
			setConnection(DatabaseSingleton.getDatabaseSingleton().getConnection(true));
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
