package oefening1;

public abstract class Vis extends Gewervelden implements IWaterdier {
	private int aantalVinnen;		
	
	public abstract void setAantalVinnen(int aantalVinnen);
	
	public abstract int getAantalVinnen();
}
