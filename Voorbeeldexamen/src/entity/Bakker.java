package entity;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.print.attribute.standard.DateTimeAtCompleted;

import business.NietAanwezigException;
import business.SorteerOpPrijs;

public class Bakker {

	private String naam;
	
	private int leeftijd;
	
	private TreeMap<Product, Date> producten = new TreeMap<Product, Date>();
	
	public static HashSet<Bakker> bakkerlijst = new HashSet<Bakker>();
	
	
	
	public String getNaam() {
		return naam;
	}
	
	public void setNaam(String naam) {
		this.naam = naam;
	}
	
	public int getLeeftijd() {
		return leeftijd;
	}
	
	public void setLeeftijd(int leeftijd) {
		this.leeftijd = leeftijd;
	}
	
	public TreeMap<Product, Date> getProducten() {
		return producten;
	}
	
	public Bakker() {
		// TODO Auto-generated constructor stub
		Bakker.bakkerlijst.add(this);
	}
	
	public Bakker(String naam, int leeftijd) {
		this.naam = naam;
		this.leeftijd = leeftijd;
		Bakker.bakkerlijst.add(this);
	}
	
	public boolean voegProductToe(Product product) {
		if(producten.containsKey(product)) {
			return false;
		}
		
		producten.put(product, new Date());
		return true;	
	}
	
	public void verwijderProduct(Product product){
		try {
		if(!producten.containsKey(product)) {
			
				throw new NietAanwezigException();
			
		}
		
		producten.remove(product);
		} catch (NietAanwezigException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public TreeMap<Product, Date> sorteerProductenOpPrijs(){
		TreeMap<Product, Date> list = new TreeMap<Product, Date>(new SorteerOpPrijs());
		list.putAll(this.producten);
		return list;
	}
	
	public void bewaar() {		 
		try(
				ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(this.naam + ".obj"));
				)
		{
			stream.writeObject(this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == this) {
			return true;
		}
		if(obj==null)
			return false;
		if(obj.getClass() != this.getClass())
			return false;
		Bakker temp = (Bakker)obj;
		if(!temp.getNaam().equals(this.naam))
			return false;
		
		// TODO: Remove when tested
		System.out.println(this.naam + " is the same as " + temp.getNaam());
		
		return true;
	}
	
	@Override
	public int hashCode() {
		int prime = 31;
		int result = 0;
		result = result * prime + ((naam == null)?0:naam.hashCode());
		return result;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.naam;
	}
}
