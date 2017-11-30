package timeout;

public class Persoon {
	
	public Persoon() {
		System.out.println("Persoon");
		this.f();
	}
	
	public void f() {
		System.out.println("f persoon");
	}
	
	public static void main(String[] args) {
		Persoon p = new Student();		
	}
}
