package entity;

import java.util.ArrayList;

public class Dvd extends AbstractMedium {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8033300371756947682L;

	public enum Taal {
		NEDERLANDS, FRANS, DUITS, ENGELS, SPAANS, ITALIAANS
	};
	
	private ArrayList<Taal> talen;
	
	public Dvd() {
		// TODO Auto-generated constructor stub
		talen = new ArrayList<Taal>();
	}
	
	public ArrayList<Taal> getTalen() {
		return talen;
	}
	
	public void setTalen(ArrayList<Taal> talen) {
		this.talen = talen;
	}

	@Override
	public void verplaatsNaarArchief() {
		// TODO Auto-generated method stub
		
	}

}
