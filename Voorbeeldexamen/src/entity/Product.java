package entity;

public abstract class Product {
	private int id;
	private String naam;
	private double prijs;
	
	public String getNaam() {
		return naam;
	}
	
	public void setNaam(String naam) {
		this.naam = naam;
	}
	
	public double getPrijs() {
		return prijs;
	}
	
	public void setPrijs(double prijs) {
		this.prijs = prijs;
	}
	
	public int getId() {
		return id;
	}

}
