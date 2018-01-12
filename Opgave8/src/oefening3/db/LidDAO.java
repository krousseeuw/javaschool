package oefening3.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import oefening3.entity.LidVO;

public class LidDAO extends BaseDAO {
	public int insert(LidVO lidVO) {
		PreparedStatement ps = null;
		String sql = "INSERT INTO leden VALUES(?,?,?)";
		
		try {
			if(getConnection().isClosed()) {
				throw new IllegalStateException(defaultErrorMessage);
			}
			ps = getConnection().prepareStatement(sql);
			
			ps.setLong(1, lidVO.getId());
			ps.setString(2, lidVO.getNaam());
			ps.setString(3, lidVO.getPaswoord());
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				closeConnections(ps);
			} catch (SQLException e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
				throw new RuntimeException(defaultErrorMessage);
			}
		}
	}
	
	public ArrayList<LidVO> selectAll(){
		ArrayList<LidVO> list = null;
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT * from leden";
		
		try {
			if(getConnection().isClosed()) {
				throw new IllegalStateException(defaultErrorMessage);
			}
			
			ps = getConnection().prepareStatement(sql);
			rs=ps.executeQuery();
			list = new ArrayList<LidVO>();
			
			while(rs.next()) {
				list.add(fillVO(rs));
			}
			
			return list;			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				closeConnections(ps, rs);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				throw new RuntimeException(defaultErrorMessage);
			}
		}
	}
	
	public LidVO selectOne(String naam) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM leden WHERE naam=?";
		
		try {
			if(getConnection().isClosed()) {
				throw new IllegalStateException(defaultErrorMessage);
			}
			
			ps = getConnection().prepareStatement(sql);
			
			ps.setString(1, naam);
			rs = ps.executeQuery();
			
			if(rs.next())
				return fillVO(rs);
			else
				return null;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				closeConnections(ps, rs);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				throw new RuntimeException(defaultErrorMessage);
			}
		}
	}

	private LidVO fillVO(ResultSet rs) throws SQLException {
		LidVO lidVO = new LidVO();
		lidVO.setId(rs.getInt(1));
		lidVO.setNaam(rs.getString("naam"));
		lidVO.setPaswoord(rs.getString("paswoord"));
		
		return lidVO;
	}	
}