package oefening2;

import voorbeeld.Input;

public class Som {
	private int getal1;
	private int getal2;
	
	private final int BOVENLOOP = 100;
	private final int ONDERLOOP = 0;
	
	public Som(int getal1, int getal2) {
		setGetal1(getal1);
		setGetal2(getal2);
	}

	public Som() {
		setGetal1(0);
		setGetal2(0);
	}
	
	public int geefSom() throws Bovenloop, Onderloop{
		if(getGetal1()+getGetal2() > BOVENLOOP)
			throw new Bovenloop();
		if(getGetal2()+getGetal2() < ONDERLOOP)
			throw new Onderloop();
		return getGetal1()+getGetal2();
	}

	private int getGetal1() {
		return this.getal1;
	}

	private void setGetal1(int getal) {
		this.getal1 = getal;
	}
	
	public int getGetal2() {
		return this.getal2;
	}

	private void setGetal2(int getal) {
		this.getal2 = getal;
	}
	
	public static void main(String[] args) {
		Som som = new Som();
		som.setGetal1(Input.readInt("getal1?"));
		som.setGetal2(Input.readInt("getal2?"));
		try {
			System.out.println(som.geefSom());
		} catch (Bovenloop e) {
			System.out.println("Bovenloop");
		} catch (Onderloop e) {
			System.out.println("Onderloop");
		}
	}
}
