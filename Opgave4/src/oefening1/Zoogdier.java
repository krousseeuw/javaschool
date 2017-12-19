package oefening1;

import javax.print.attribute.standard.RequestingUserName;

public abstract class Zoogdier extends Gewervelden{
	private int lengteZwangerschap;
		
	public Zoogdier() {
		super();
	}
	
	/**
	 * @param naam
	 * @param lengte
	 * @param type
	 * @param lengteZwanger
	 */
	public Zoogdier(String naam, double lengte, HuidType type, int lengteZwanger) {
		super(naam, lengte, type);
		this.lengteZwangerschap = lengteZwanger;
	}
	
	/**
	 * 
	 * @return the lengteZwangerschap
	 */
	public int getLengteZwanger() {
		return this.lengteZwangerschap;
	}
	
	/** 
	 * @param lengteZwanger
	 */
	public void setLengteZwanger(int lengteZwanger) {
		this.lengteZwangerschap = lengteZwanger;
	}
}