package oefening1;

public abstract class Gewervelden extends Dier {
	public Gewervelden() {
		super();
	}
	public Gewervelden(String naam, int lengte, HuidType type) {
		super(naam);
		this.lengte = lengte;
		this.huidtype = type;
	}
	public enum HuidType {
		BEHAARD, SCHUBBEN, VEREN
	}
	protected double lengte;
	protected HuidType huidtype;	
	
	public HuidType getHuidType() {
		return this.huidtype;
	}
	
	public void setHuidType(HuidType type) {
		this.huidtype = type;
	}
	
	public double getLengte() {
		return this.lengte;
	}
	
	public void setLengte(double lengte) {
		this.lengte = lengte;
	}
}
