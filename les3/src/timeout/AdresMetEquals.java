package timeout;

public class AdresMetEquals extends Adres {
	public AdresMetEquals(String gemeente) {
		super(gemeente);
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gemeente==null)?0:gemeente.hashCode());
		return result;
	}
	
	public boolean equals(Object obj) {
		if(this==obj)
			return true;
		if (obj==null)
			return false;
		if(getClass()!=obj.getClass())
			return false;
		AdresMetEquals other = (AdresMetEquals)obj;
		if(gemeente == null) {
			if(other.gemeente!=null)
				return false;
		} else if(!gemeente.equals(other.gemeente))
			return false;
		return true;		
	}
	
	public static void main (String str[]) {
		AdresMetEquals adres1 = new AdresMetEquals("Brussel");
		AdresMetEquals adres2 = new AdresMetEquals("Brussel");
		System.out.println(adres1.equals(adres2));
	}
}
