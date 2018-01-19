package entity;

public abstract class Product implements Comparable<Product> {
	private int id;
	private String naam;
	private Double prijs;
	
	public String getNaam() {
		return naam;
	}
	
	public void setNaam(String naam) {
		this.naam = naam;
	}
	
	public Double getPrijs() {
		return prijs;
	}
	
	public void setPrijs(double prijs) {
		this.prijs = prijs;
	}
	
	public int getId() {
		return id;
	}

	public abstract void geefProductbeschrijving();
	
	@Override
	public int compareTo(Product o) {
		// TODO Auto-generated method stub
		return this.naam.compareTo(o.getNaam());
	}
}
