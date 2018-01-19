package entity;

public class WitBrood extends Brood implements ISpecialiteit {

	public Topping topping;
	
	public enum Topping{
		ZONNEBLOEMPITTEN, SESAMZAAD, GRANEN, GEEN
	}
	
	public Topping getTopping() {
		return topping;
	}
	
	public void setTopping(Topping topping) {
		this.topping = topping;
	}

	@Override
	public void geefProductbeschrijving() {
		System.out.println("Ik ben wit brood");
	}

	@Override
	public void geefSpecialisatieNiveau() {
		System.out.println("Ik ben speciaal wit brood");

	}
}