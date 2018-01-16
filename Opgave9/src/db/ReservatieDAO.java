package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

import entity.ReservatieVO;

public class ReservatieDAO extends BaseDAO {
	public int insert(ReservatieVO r) {
		String sql = "INSERT INTO reservatie VALUES(?,?,?)";
		
		try (PreparedStatement ps = getConnection().prepareStatement(sql);){
			if(getConnection().isClosed()) {
				throw new IllegalStateException(defaultErrorMessage);
			}
			
			ps.setInt(1, r.getFilmID());
			ps.setInt(2, r.getZaal());
			
			ps.setTimestamp(3, new java.sql.Timestamp(r.getAanvang().getTimeInMillis()));
			return ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());;
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public ArrayList<ReservatieVO> selectAll(){
		ArrayList<ReservatieVO> list = null;
		String sql = "SELECT * FROM reservatie";
		
		try(
				Statement s = getConnection().createStatement();
				ResultSet rs = s.executeQuery(sql);
				){
			if(getConnection().isClosed()) {
				throw new IllegalStateException(defaultErrorMessage);
			}
			
			list = new ArrayList<ReservatieVO>();
			while(rs.next()) {
				Calendar c = Calendar.getInstance();
				c.setTimeInMillis(rs.getTimestamp(3).getTime());
				list.add(new ReservatieVO(rs.getInt(1), rs.getInt(2), c));
			}
			
			return list;
		} catch (SQLException e) {
			System.out.println(e.getMessage());;
			throw new RuntimeException(e.getMessage());
		}
	}
}
