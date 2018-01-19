package db;

import java.sql.Connection;

public abstract class BaseDAO {
	
	Connection connection;
	
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	public Connection getConnection() {
		return connection;
	}

	public BaseDAO(Connection connection) {
		// TODO Auto-generated constructor stub
		this.connection = connection;
	}
}
