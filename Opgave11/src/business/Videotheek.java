package business;

import entity.Dvd;
import gui.VideoApp;

public class Videotheek {
	public static void main(String[] args) {
		Dvd dvd1 = new Dvd();
		dvd1.setTitel("The Last Unicorn: Enchanted Edition");
		Dvd dvd2 = new Dvd();
		dvd2.setTitel("Kung Fu Pand 3");
		Dvd dvd3 = new Dvd();
		dvd3.setTitel("Moana");
		Dvd dvd4 = new Dvd();
		dvd4.setTitel("One Piece: Strong World");
		
		Klant klant1 = new Klant();
		klant1.setNaam("Data");
		klant1.huur(dvd1);
		klant1.huur(dvd2);
		Klant klant2 = new Klant();
		klant2.setNaam("Trapezius");
		klant2.huur(dvd3);
		klant2.huur(dvd4);
		VideoApp app = new VideoApp();
	}
}