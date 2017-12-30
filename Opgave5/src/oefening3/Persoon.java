package oefening3;

public class Persoon {
	private String naam;
	
	private String password;
	
	private String adres;
	
	public Persoon() {
		super();
	}
	
	public Persoon(String naam, String password) {
		super();
		this.naam = naam;
		this.password = password;
	}
	
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public String getPaswoord() {
		return password;
	}
	public void setPaswoord(String paswoord) {
		this.password = paswoord;
	}
	public String getAdres() {
		return adres;
	}
	public void setAdres(String adres) {
		this.adres = adres;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((naam==null)?0:naam.hashCode());
		result = prime * result + ((password==null)?0:password.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) 
			return true;
		if(obj==null) 
			return false;
		if(getClass()!=obj.getClass())
			return false;
		final Persoon other = (Persoon) obj;
		if(naam==null) {
			if(other.naam==null)
				return false;
		}else if(!naam.equals(other.naam))
			return false;
		if(password==null) {
			if(other.password!=null)
				return false;
		} else if(!password.equals(other.password))
			return false;
		return true;
			
	}
}
