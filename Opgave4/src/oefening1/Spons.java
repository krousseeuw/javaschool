package oefening1;

public abstract class Spons extends Ongewervelden implements IWaterdier {
	
	/**
	 * @param naam
	 * @param kleur
	 */
	public Spons(String naam, Kleur kleur) {
		super(naam, kleur);
	}
	
	@Override
	public String maakGeluid() {
		// Alle sponsen maken een vergelijkbaar geluid
		return "...";
	}
	
	@Override
	public int geefTijdOnderWater() {
		// Alle sponsen kunnen onder water blijven
		return 0;
	}
}
