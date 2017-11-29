package timeout;
	
public class Test {
	
	private Persoon p;
	
	public Test(Persoon x) {
		System.out.println(p);
		p = x;
		System.out.println(p);
	}
	
	public static void main(String[] args) {
		Persoon persoon = new Persoon();
		Test t = new Test(persoon);
	}
}
