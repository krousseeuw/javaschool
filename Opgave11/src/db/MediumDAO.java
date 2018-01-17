package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entity.AbstractMedium;

public class MediumDAO extends BaseDAO {
	public int insert(AbstractMedium medium) {
		String sql = "INSERT INTO MediumVO VALUES(?,?)";
		
		try(PreparedStatement ps = getConnection().prepareStatement(sql)){
			if(getConnection().isClosed()) {
				throw new IllegalStateException(defaultErrorMessage);
			}
			
			ps.setString(1, medium.getRegisseur());
			ps.setString(2, medium.getTitel());
			
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e.getMessage());
		}		
	}
	
	//public ArrayList<AbstractMedium> selectAll(){
	//	ArrayList<AbstractMedium> list = null;
	//	String sql = "SELECT * FROM MediumVO";
	//	
	//	try(
	//			Statement s=getConnection().createStatement();
	//			ResultSet rs=s.executeQuery(sql);
	//		){
	//		if(getConnection().isClosed()) {
	//			throw new IllegalStateException(defaultErrorMessage);				
	//		}
	//		list = new ArrayList<AbstractMedium>();
	//		
	//		while(rs.next()) {
	//			list.add(new AbstractMedium(rs.getString(1), rs.getString(2)));
	//		}
	//		
	//		return list;
	//	} catch (SQLException e) {
	//		System.out.println(e.getMessage());
	//		throw new RuntimeException(e.getMessage());
	//	}
	//}
}
