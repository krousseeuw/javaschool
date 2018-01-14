package entity;

import java.util.Calendar;

public class ReservatieVO {
	private int filmID;
	private int zaal;
	private Calendar aanvang;
	
	public int getFilmID() {
		return filmID;
	}
	
	public void setFilmID(int filmID) {
		this.filmID = filmID;
	}
	
	public int getZaal() {
		return zaal;
	}
	
	public void setZaal(int zaal) {
		this.zaal = zaal;
	}
	
	public Calendar getAanvang() {
		return aanvang;
	}
	
	public void setAanvang(Calendar aanvang) {
		this.aanvang = aanvang;
	}
	
	public ReservatieVO(int filmID, int zaal, Calendar aanvang) {
		super();
		this.filmID = filmID;
		this.zaal=zaal;
		this.aanvang=aanvang;		
	}
}