package oefening1;

import java.io.Serializable;

import javax.print.attribute.standard.MediaSize.Other;

public class Product implements Comparable<Product>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6716561993137481293L;

	private String naam;
	
	private int nummer;
	
	public String getNaam() {
		return naam;
	}
	
	public void setNaam(String naam) {
		this.naam = naam;
	}
	
	public int getNummer() {
		return nummer;
	}

	public void setNummer(int nummer) {
		this.nummer = nummer;
	}	
	
	@Override
	public int compareTo(Product o) {
		// TODO Auto-generated method stub
		return this.nummer - o.nummer;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + nummer;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this==obj)
			return true;
		if(obj==null)
			return false;
		if(getClass() != obj.getClass());
		Product other = (Product) obj;
		if(nummer != other.nummer)
			return false;
		return true;
	}	
}