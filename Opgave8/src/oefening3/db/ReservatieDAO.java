package oefening3.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import oefening3.entity.BoekVO;
import oefening3.entity.LidVO;
import oefening3.entity.ReservatieVO;

public class ReservatieDAO extends BaseDAO {
	public int insert (ReservatieVO reservatieVO) {
		PreparedStatement ps = null;
		
		String sql = "INSERT INTO reservaties VALUES(?,?)";
		
		try {
			if(getConnection().isClosed()) {
				throw new IllegalStateException(defaultErrorMessage);
			}
			
			ps=getConnection().prepareStatement(sql);
			
			ps.setInt(1, reservatieVO.getLidVO().getId());
			ps.setLong(2, reservatieVO.getBoekVO().getIsbn());
			
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				closeConnections(ps);
			} catch(SQLException e) {
				System.out.println(e.getMessage());
				throw new RuntimeException(defaultErrorMessage);
			}
		}
	}
	
	public ArrayList<BoekVO> selectVanLid(LidVO lidVO){
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<BoekVO> list=null;
		String sql = "SELECT * FROM reservaties WHERE id=?";
		
		try {
			if(getConnection().isClosed()) {
				throw new IllegalStateException("error unexpected");
			}
			
			ps=getConnection().prepareStatement(sql);
			
			ps.setLong(1, lidVO.getId());
			rs = ps.executeQuery();
			list = new ArrayList<BoekVO>();
			while(rs.next()) {
				list.add(fillBoekVO(rs));				
			}
			
			return list;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				closeConnections(ps, rs);
			} catch (SQLException e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
				throw new RuntimeException(defaultErrorMessage);
			}
		}
	}

	private BoekVO fillBoekVO(ResultSet rs) throws SQLException {
		BoekDAO boekDAO = new BoekDAO();
		return boekDAO.selectOne(rs.getLong("isbn"));
	}
}