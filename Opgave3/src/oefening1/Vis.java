package oefening1;

public abstract class Vis extends Gewervelden implements IWaterdier {
	private int aantalVinnen;	
	
	public Vis() {
		
	}
	
	public Vis(String naam, int lengte, HuidType type, int aantalvinnen) {
		super(naam, lengte, type);
		this.aantalVinnen = aantalvinnen;
	}
	
	public void setAantalVinnen(int aantalVinnen) {
		this.aantalVinnen = aantalVinnen;
	}
	
	public int getAantalVinnen() {
		return this.aantalVinnen;
	}
	
	@Override
	public String maakGeluid() {
		return "blub";
	}
	
	@Override
	public int geefTijdOnderWater() {
		// TODO Auto-generated method stub
		return 0;
	}
}
