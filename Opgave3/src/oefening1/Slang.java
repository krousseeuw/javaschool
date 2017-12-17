package oefening1;

public class Slang extends Reptiel {

	public Slang(String naam, int lengte, HuidType type) {
		super(naam, lengte, type);
	}
	
	@Override
	public String maakGeluid() {
		return "ssss";
	}

}
