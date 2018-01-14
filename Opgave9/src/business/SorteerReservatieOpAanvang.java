package business;

import java.util.Comparator;

import entity.ReservatieVO;

public class SorteerReservatieOpAanvang implements Comparator<ReservatieVO> {
	@Override
	public int compare(ReservatieVO o1, ReservatieVO o2) {
		return o1.getAanvang().compareTo(o1.getAanvang());
	}
}