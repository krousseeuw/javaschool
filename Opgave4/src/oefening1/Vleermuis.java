package oefening1;

import java.awt.Window.Type;

public class Vleermuis extends Zoogdier implements IVliegt{

	public Vleermuis(String naam, float lengte, HuidType type) {
		super(naam, lengte, type, 4);
	}
	
	@Override
	public String maakGeluid() {
		// TODO Auto-generated method stub
		return "piep";
	}

	@Override
	public void vliegt() {
		// TODO Auto-generated method stub
		
	}

}
