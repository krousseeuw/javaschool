package db;

import java.sql.Statement;
import java.security.interfaces.RSAKey;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.FilmVO;

public class FilmDAO extends BaseDAO {
	public int insert (FilmVO f) {
		String sql = "INSERT INTO film VALUES(null,?,?)";
		
		try(
				PreparedStatement ps = getConnection().prepareStatement(sql);
				){
			if(getConnection().isClosed()) {
				throw new IllegalStateException(defaultErrorMessage);
			}
			ps.setString(1, f.getTitel());
			ps.setInt(2, f.getDuur());
			return ps.executeUpdate();			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e.getMessage());
		}		
	}
	
	public ArrayList<FilmVO> selectAll(){
		ArrayList<FilmVO> list = null;
		String sql = "SELECT * FROM film";
		
		try(
				Statement s = getConnection().createStatement();
				ResultSet rs = s.executeQuery(sql);
				){
			if(getConnection().isClosed()) {
				throw new IllegalStateException(defaultErrorMessage);
			}
			list = new ArrayList<FilmVO>();
			
			while(rs.next()) {
				list.add(new FilmVO(rs.getInt(3), rs.getString(2), rs.getInt(1)));
			}
			
			return list;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public FilmVO selectFilmWithID(int ID) {
		FilmVO film = null;
		String sql = "SELECT * FROM film where ID=?";
		ResultSet rs = null;
		
		try(
				PreparedStatement ps = getConnection().prepareStatement(sql);
				){
			if(getConnection().isClosed()) {
				throw new IllegalStateException(defaultErrorMessage);
			}
			
			ps.setInt(1, ID);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				film = new FilmVO(rs.getInt(3), rs.getString(2), rs.getInt(1));
			}
			
			return film;
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException("error.unexpected");
		} finally {
			try {
				closeConnection(rs);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				throw new RuntimeException("error.unexpected");
			}
		}	
	}
}
