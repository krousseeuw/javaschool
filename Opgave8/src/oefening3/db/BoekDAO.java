package oefening3.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.management.RuntimeErrorException;

import oefening3.entity.BoekVO;

public class BoekDAO extends BaseDAO {
	public BoekDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public BoekDAO(Connection con) {
		setConnection(con);
	}
	
	public int insert(BoekVO boekVO) {
		PreparedStatement ps=null;
		
		String sql = "INSERT INTO boeken VALUES(?,?,?)";
		
		try {
			if(getConnection().isClosed()) {
				throw new IllegalStateException("error unexpected");
			}
			
			ps = getConnection().prepareStatement(sql);
			
			ps.setLong(1, boekVO.getIsbn());
			ps.setString(2, boekVO.getTitel());
			ps.setString(3, boekVO.getAuteur());
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if(ps!=null)
					ps.close();
			} catch(SQLException e) {
				System.out.println(e.getMessage());
				throw new RuntimeException("error unexpected");
			}
		}
	}

	public ArrayList<BoekVO> selectAll(){
		ArrayList<BoekVO> list = null;
		
		PreparedStatement ps=null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM boeken";
		
		try {
			if(getConnection().isClosed()) {
				throw new IllegalStateException(defaultErrorMessage);
			}
			
			ps.getConnection().prepareStatement(sql);
			rs = ps.executeQuery();
			list = new ArrayList<BoekVO>();
			
			while(rs.next()) {
				list.add(fillVO(rs));
			}
			
			return list;
		} catch(SQLException e) {
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
	
	public BoekVO selectOne(long isbn) {
		PreparedStatement ps = null;
		ResultSet rs = null;		
		String sql = "SELECT * FROM boeken WHERE isbn=?";
		
		try {
			if(getConnection().isClosed()) {
				throw new IllegalStateException(defaultErrorMessage);
			}
			
			ps = getConnection().prepareStatement(sql);
			
			ps.setLong(1, isbn);
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
	
	private BoekVO fillVO(ResultSet rs) throws SQLException {
		BoekVO boekVO = new BoekVO();
		boekVO.setIsbn(rs.getLong(1));
		boekVO.setTitel(rs.getString(2));
		boekVO.setAuteur(rs.getString(3));
		return boekVO;
	}
	
	public int delete(BoekVO boekVO) {
		PreparedStatement ps=null;
		ResultSet rs=null;
		int resultaat=0;
		String sql = "DELETE FROM boeken WHERE isbn=?";
		
		try {
			if(getConnection().isClosed()) {
				throw new IllegalStateException(defaultErrorMessage);				
			}
			
			ps = getConnection().prepareStatement(sql);
			ps.setLong(1, boekVO.getIsbn());
			resultaat = ps.executeUpdate();			
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
		
		return resultaat;
	}
}
