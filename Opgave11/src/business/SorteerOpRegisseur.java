package business;

import java.util.Comparator;

import entity.AbstractMedium;

public class SorteerOpRegisseur implements Comparator<AbstractMedium> {

	@Override
	public int compare(AbstractMedium o1, AbstractMedium o2) {
		return o1.getRegisseur().compareTo(o2.getRegisseur());
	}

	
	

}
