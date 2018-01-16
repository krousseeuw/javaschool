package entity;

public class FilmForCombobox {
	
	private int duur;
	private String titel;
	private int ID;
	
	public FilmForCombobox(FilmVO f) {
		this.duur = f.getDuur();
		this.titel = f.getTitel();
		this.ID = f.getID();
	}
	
	@Override
	public String toString() {
		return titel;
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
		ID = iD;
	}
}