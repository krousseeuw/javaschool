package business;

import java.util.Comparator;

import entity.AbstractMedium;

public class SorteerOpTitel implements Comparator<AbstractMedium> {

	@Override
	public int compare(AbstractMedium o1, AbstractMedium o2) {
		// TODO Auto-generated method stub
		return o1.getTitel().compareTo(o2.getTitel());
	}

}
