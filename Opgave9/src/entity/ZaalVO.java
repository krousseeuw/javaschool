package entity;

public class ZaalVO {
	private int nummer;
	private int zitplaatsen;
	
	public ZaalVO(int nummer, int zitplaatsen) {
		this.nummer = nummer;
		this.zitplaatsen = zitplaatsen;
	}
	
	@Override
	public String toString() {
		return "Zaal "+nummer;
	}
	
	public int getNummer() {
		return nummer;
	}
	
	public void setNummer(int nummer) {
		this.nummer = nummer;
	}
	
	public int getZitplaatsen() {
		return zitplaatsen;
	}
	
	public void setZitplaatsen(int zitplaatsen) {
		this.zitplaatsen = zitplaatsen;
	}
}