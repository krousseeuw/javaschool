package oefening1;

public class Gans extends Vogel implements IVliegt, IWaterdier {

	public Gans(String naam, float lengte, HuidType type) {
		super(naam, lengte, type);
	}
	
	@Override
	public int geefTijdOnderWater() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void vliegt() {
		// TODO Auto-generated method stub
	
	}

	@Override
	public String maakGeluid() {
		// TODO Auto-generated method stub
		return "gak";
	}

}
