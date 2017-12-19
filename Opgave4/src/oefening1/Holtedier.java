package oefening1;

public abstract class Holtedier extends Ongewervelden implements IWaterdier {
	private double diameterHolte;

	/**
	 * @param naam
	 * @param kleur
	 * @param diam
	 */
	public Holtedier(String naam, Kleur kleur, int diam) {
		super(naam, kleur);
		this.diameterHolte = diam;
	}
	
	/**
	 * @return diameterHolte
	 */
	public double getDiameter() {
		return diameterHolte;
	}
	
	/**
	 * @param diameter
	 */
	public void setDiameter(double diameter) {
		this.diameterHolte = diameter;
	}
	
	@Override
	public String maakGeluid() {
		return "blubber";
	}
}