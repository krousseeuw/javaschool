package timeout;

public class Adres {
	protected String gemeente;
	
	public Adres(String gemeente) {
		this.gemeente = gemeente;
	}
	
	public String getGemeente() {
		return gemeente;
	}
	
	public void setGemeente(String gemeente) {
		this.gemeente = gemeente;
	}
	
	public String toString() {
		return "Adres [gemeente="+gemeente+"]";
	}
	
	public static void main(String str[]) {
		Adres adres1 = new Adres("Brussel");
		Adres adres2 = new Adres("Brussel");
		System.out.println(adres1.equals(adres2));
	}
}
