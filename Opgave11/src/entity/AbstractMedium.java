package entity;

import java.io.Serializable;

import javax.security.auth.x500.X500Principal;

public abstract class AbstractMedium implements Serializable, Comparable<AbstractMedium> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8452179629250826340L;
	
	private String titel;
	
	private String regisseur;
	
	private String inhoud;
	
	private Taal talenOndertiteling[];
	
	public enum Taal{
		NEDERLANDS, FRANS, DUITS, ENGELS, SPAANS, ITALIAANS
	}
	
	public String getTitel() {
		return titel;
	}
	
	public void setTitel(String titel) {
		this.titel = titel;
	}
	
	public String getRegisseur() {
		return regisseur;
	}
	
	public void setRegisseur(String regisseur) {
		this.regisseur = regisseur;
	}
	
	public String getInhoud() {
		return inhoud;
	}
	
	public void setInhoud(String inhoud) {
		this.inhoud = inhoud;
	}
	
	public Taal[] getTalenOndertiteling() {
		return talenOndertiteling;
	}
	
	public void setTalenOndertiteling(Taal[] talenOndertiteling) {
		this.talenOndertiteling = talenOndertiteling;
	}
	
	@Override
	public int compareTo(AbstractMedium o) {
		// TODO Auto-generated method stub
		return this.getTitel().compareTo(o.getTitel());
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName()+" "+getTitel();
	}
	
	public AbstractMedium() {
		
	}

	public AbstractMedium(String titel, String regisseur) {
		// TODO Auto-generated constructor stub
	}

	public abstract void verplaatsNaarArchief();
	
}
