package entity;

public class Chocolade extends Patisserie implements ISpecialiteit {

	@Override
	public void geefProductbeschrijving() {
		System.out.println("Ik ben chocolade");
	}

	@Override
	public void geefSpecialisatieNiveau() {
		// TODO Auto-generated method stub
		System.out.println("Ik ben speciale chocolade");
	}

}
