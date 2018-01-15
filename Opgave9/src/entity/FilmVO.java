package entity;

public class FilmVO implements Comparable<FilmVO> {
	private int duur;
	private String titel;
	private int ID;

	public FilmVO(int duur, String titel) {
		// TODO Auto-generated constructor stub
		this.duur = duur;
		this.titel = titel;
	}
	
	public FilmVO(int duur, String titel, int iD) {
		this.duur = duur;
		this.titel = titel;
		this.ID = iD;
	}
	
	public int getDuur() {
		return duur;
	}
	
	public void setDuur(int duur) {
		this.duur = duur;
	}
	
	public String getTitel() {
		return titel;
	}
	
	public void setTitel(String titel) {
		this.titel = titel;
	}
	
	public int getID() {
		return ID;
	}
	
	public void setID(int iD) {
		this.ID = iD;
	}
	
	@Override
	public int compareTo(FilmVO o) {
		return this.titel.compareTo(o.titel);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this==obj) {
			return true;
		}
		if(obj==null) {
			return false;
		}
		if(getClass() != obj.getClass()) {
			return false;
		}
		FilmVO other = (FilmVO) obj;
		if (ID != other.ID)
			return false;
		return true;
	}
}
