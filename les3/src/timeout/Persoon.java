package timeout;

public class Persoon {
	private Adres adres;
	
	public Adres getAdres() {
		return adres;
	}
	
	public void veranderGemeente(Adres adres) {
		adres = new Adres("Houthulst");
	}
	
	public void setAdres(Adres adres) {
		this.adres = adres;
	}
	
	public static void main(String str[]) {
		Adres adres = new Adres("Vielsalm");
		Persoon persoon = new Persoon();
		persoon.setAdres(adres);
		adres.setGemeente("Sint-Andries");
		System.out.println(persoon.getAdres());
		persoon.veranderGemeente(adres);
		System.out.println(adres);
	}
}
