package oefening3.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class BaseDAO {
	private Connection connection;
	protected final String defaultErrorMessage = "error unexpected";
	
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

	protected void closeConnections(PreparedStatement ps, ResultSet rs) throws SQLException{
		if(ps!=null)
			ps.close();
		if(rs!=null)
			rs.close();
	}
	
	protected void closeConnections(PreparedStatement ps) throws SQLException {
		if(ps!=null)
			ps.close();
	}
}
