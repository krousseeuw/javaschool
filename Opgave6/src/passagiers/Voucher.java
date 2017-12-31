package passagiers;

public class Voucher {
	public enum TypeVoucher{
		MAALTIJD, FRISDRANK, ALCOHOL
	};
	
	private TypeVoucher type;
	
	private double identificatienummer;
	
	public Voucher(TypeVoucher type, double identificatienummer) {
		super();
		this.type = type;
		this.identificatienummer= identificatienummer;
	}
	
	public TypeVoucher getType() {
		return this.type;
	}
	
	public double getIdentificatienummer() {
		return identificatienummer;
	}	
	
	@Override
	public String toString() {
		return identificatienummer + " (" + type + ")";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(identificatienummer);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		final Voucher other = (Voucher) obj;
		if(Double.doubleToLongBits(identificatienummer)!=Double.doubleToLongBits(other.identificatienummer))
			return false;
		return true;
	}
}