package business;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import entity.Bakker;
import entity.Brood;
import entity.Chocolade;
import entity.ISpecialiteit;
import entity.Product;
import entity.WitBrood;

public class Test {

	public static void main(String[] args) {
		ArrayList<ISpecialiteit> testlistIspecialiteit = new ArrayList<ISpecialiteit>();
		ISpecialiteit witBrood = new WitBrood();
		ISpecialiteit chocolade = new Chocolade();
		Product witChoco = new Chocolade();
		Product gewonechoco = new Chocolade(); 
		((Chocolade)chocolade).setNaam("Gewone chocolade");
		witChoco.setNaam("Witte chocolade");
		gewonechoco.setNaam("Gewone chocolade");
		
		testlistIspecialiteit.add(chocolade);
		testlistIspecialiteit.add(witBrood);
		
		for(ISpecialiteit item : testlistIspecialiteit) {
			item.geefSpecialisatieNiveau();
		}
		
		Bakker bakkertest = new Bakker("Joeri", 11);
		Bakker bakkerGelijk = new Bakker("Joeri", 23);
		Bakker bakkerAnders = new Bakker("Marco", 23);
		
		
		for(Bakker item : Bakker.bakkerlijst) {
			System.out.println(item.getNaam());			
		}
		
		System.out.println(bakkertest.voegProductToe(witChoco));
		System.out.println(bakkertest.voegProductToe((Product) chocolade));
		System.out.println(bakkertest.voegProductToe(gewonechoco));

		bakkertest.verwijderProduct(witChoco);
		
		for(Map.Entry<Product, Date> item : bakkertest.getProducten().entrySet()) {
			Product product = item.getKey();
			System.out.println(product.getNaam());
		}

		
	}
}
