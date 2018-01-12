package oefening3.business;

import java.sql.SQLException;

import oefening3.db.BoekDAO;
import oefening3.db.DatabaseSingleton;
import oefening3.db.LidDAO;
import oefening3.db.ReservatieDAO;
import oefening3.entity.BoekVO;
import oefening3.entity.LidVO;
import oefening3.entity.ReservatieVO;

public class Bibliotheek {
	public void initializeDatabase() {
		BoekVO boekVO = new BoekVO();
		boekVO.setAuteur("Peter S. Beagle");
		boekVO.setTitel("The Last Unicorn");
		boekVO.setIsbn(1000);
		BoekDAO boekDAO = new BoekDAO();
		
		boekDAO.insert(boekVO);
		
		// lid toevoegen
		LidVO lidVO = new LidVO();
		
		lidVO.setNaam("Kuja");
		lidVO.setPaswoord("1234");
		LidDAO lidDAO = new LidDAO();
		
		lidDAO.insert(lidVO);
		
		// reservatie aanmaken
		ReservatieVO reservatieVO = new ReservatieVO();
		reservatieVO.setBoekVO(boekVO);
		reservatieVO.setLidVO(lidDAO.selectOne("Kuja"));
		ReservatieDAO reservatieDAO = new ReservatieDAO();
		reservatieDAO.insert(reservatieVO);
	}
	
	public static void main(String[] str) {
		Bibliotheek bibliotheek = new Bibliotheek();
		bibliotheek.initializeDatabase();
		
		try {
			DatabaseSingleton.getDatabaseSingleton().getConnection(true).close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
