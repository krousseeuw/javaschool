package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entity.Bakker;

public class BakkerDAO extends BaseDAO {

	public BakkerDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Bakker> geefAlleBakkers(){
		String sql = "SELECT * FROM bakkers";
		ArrayList<Bakker> list = new ArrayList<Bakker>();
		try (
				Statement statement = getConnection().createStatement();
				ResultSet rSet = statement.executeQuery(sql);
				){
			if(getConnection().isClosed()) {
				throw new IllegalStateException("error unexpected");
			}
			
			while(rSet.next()) {
				list.add(new Bakker(rSet.getString(1), rSet.getInt(2)));
			}
			return list;
			
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public boolean verwijderBakker(Bakker bakker) {
		String sql = "DELETE * FROM bakkers WHERE naam=?";
		int resultaat = 0;
		try(
				PreparedStatement pStatement = getConnection().prepareStatement(sql);
				){
			if(getConnection().isClosed()) {
				throw new IllegalStateException("error unexpected");
			}
			pStatement.setString(1, bakker.getNaam());
			resultaat = pStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e.getMessage());
		} 
		return resultaat>0;
	}
}
