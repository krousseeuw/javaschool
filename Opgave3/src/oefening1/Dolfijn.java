package oefening1;

public class Dolfijn extends Zoogdier implements IWaterdier {
	
	public Dolfijn() {
		// TODO Auto-generated constructor stub
	}
	
	public Dolfijn(String naam, int lengte, HuidType type) {
		super(naam, lengte, type, 4);
	}

	@Override
	public String maakGeluid() {
		
		return "kwek";
	}

	@Override
	public int geefTijdOnderWater() {
		return 0;
	} 
}