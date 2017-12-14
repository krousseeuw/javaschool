package oefening1;

public class Holtedier extends Ongewervelden {
	private double diameterHolte;

	@Override
	public void setKleur(String kleur) {
		// TODO Auto-generated method stub
		this.kleur = kleur;
	}

	@Override
	public String getKleur() {
		return this.kleur;
		// TODO Auto-generated method stub
		
	}

	@Override
	public String maakGeluid() {
		return this.geluid;
	}

	@Override
	public void setGeluid(String geluid) {
		this.geluid = geluid;		
	}
}
