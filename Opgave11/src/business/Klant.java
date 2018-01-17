package business;

import java.util.List;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;

import entity.AbstractMedium;
import entity.Dvd;

public class Klant {

	private static ArrayList<Klant> klantenlijst = new ArrayList<Klant>();
	
	private String naam;
	
	private TreeMap<AbstractMedium, Date> verhuur = new TreeMap<AbstractMedium, Date>();
	
	public Klant() {
		Klant.klantenlijst.add(this);
	}

	public boolean huur(AbstractMedium x) {
		// TODO Auto-generated method stub
		if(verhuur.put(x, new Date())!=null) {
			return true;
		} else {
			return false;
		}
	}
	
	public void inlevering(AbstractMedium x) throws TooLate, NoSuchItem{
		Date verhuurdatum;
		
		if(verhuur.containsKey(x)) {
			verhuurdatum = verhuur.get(x);
		} else {
			throw new NoSuchItem();
		}
		
		Date now = new Date();
		
		if(now.getTime() - verhuurdatum.getTime() > 21 * 1000 * 60 * 60 * 24) {
			throw new TooLate();
		}
		
		verhuur.remove(x);
	}
	
	public boolean save() {
		boolean success = false;
		
		PrintWriter printWriter = null;
		try {
			printWriter = new PrintWriter(naam + ".txt");
			printWriter.println(naam);
			
			for(AbstractMedium medium : verhuur.keySet()) {
				printWriter.print(medium.getTitel() + " ");
				printWriter.println(verhuur.get(medium));				
			}

			success = true;			
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			printWriter.close();
		}
		
		return success;
	}
	
	public String getNaam() {
		return naam;
	}
	
	public void setNaam(String naam) {
		this.naam = naam;
	}
	
	@Override
	public String toString() {
		String verhuur = "";
		Iterator<AbstractMedium> xIterator = this.verhuur.keySet().iterator();
		
		while(xIterator.hasNext()) {
			verhuur += xIterator.next().getTitel() + "\n";
		}
		
		return verhuur;
	}
	
	public static ArrayList<Klant> getKlantenlijst() {
		return klantenlijst;
	}

	public String sorteerOpTitel() {
		TreeSet<AbstractMedium> set = new TreeSet<AbstractMedium>( new SorteerOpTitel());
		set.addAll(verhuur.keySet());
		String output = "";
		for(AbstractMedium medium : set) {
			output += medium.getTitel();
		}
		
		return output;
	}
	
	public List<AbstractMedium> sorteerOpRegisseur(){
		ArrayList<AbstractMedium> list = new ArrayList<AbstractMedium>(verhuur.keySet());
		Collections.sort(list, new SorteerOpRegisseur());
		return list;
	}
}