package business;

import java.util.Comparator;

import entity.Product;

public class SorteerOpPrijs implements Comparator<Product> {

	@Override
	public int compare(Product o1, Product o2) {
		return o1.getPrijs().compareTo(o2.getPrijs());
	}

}
