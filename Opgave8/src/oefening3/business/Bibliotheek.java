package oefening3.business;

import oefening3.db.BoekDAO;
import oefening3.entity.BoekVO;

public class Bibliotheek {
	public void initializeDatabase() {
		BoekVO boekVO = new BoekVO();
		boekVO.setAuteur("Peter S. Beagle");
		boekVO.setTitel("The Last Unicorn");
		boekVO.setIsbn(1000);
		BoekDAO boekDAO = new BoekDAO();
		
	}

}
