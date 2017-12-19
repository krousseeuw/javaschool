package oefening1;

import javax.management.loading.PrivateClassLoader;
import javax.xml.crypto.dsig.SignatureProperties;

public abstract class Ongewervelden extends Dier {
	
	public enum Kleur {
		ZWART, GEEL, ROOD
	};
	
	private Kleur kleur;
	
    public Ongewervelden() {
    	super();
    }
    
    public Ongewervelden(String naam, Kleur kleur) {
    	super(naam);
    	this.kleur = kleur;
    }
	
	public void setKleur(Kleur kleur) {
		this.kleur = kleur;
	}
	
	public Kleur getKleur() {
		return kleur;
	}
}
