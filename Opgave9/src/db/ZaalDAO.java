package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entity.ZaalVO;

public class ZaalDAO extends BaseDAO{
	
	public ArrayList<ZaalVO> selectAll(){
		ArrayList<ZaalVO> list = null;
		
		String sql = "SELECT * FROM zaal";
		
		try (
				Statement s = getConnection().createStatement();
				ResultSet rs = s.executeQuery(sql);
						) {
			if(getConnection().isClosed()) {
				throw new IllegalStateException(defaultErrorMessage);
			}			
			
			list = new ArrayList<ZaalVO>();
			
			while(rs.next()) {
				list.add(new ZaalVO(rs.getInt(1), rs.getInt(2)));
			}
			
			return list;			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e.getMessage());
		}		
	}
}