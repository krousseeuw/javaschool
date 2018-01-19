package ui;

import entity.Bakker;

// Use seperate class so that you can set a tostring to the value you want to display
public class Bakker4Combobox {
	private Bakker bakker;
	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return bakker.getNaam();
	}

	public Bakker getBakker() {
		return bakker;
	}
	
	public void setBakker(Bakker bakker) {
		this.bakker = bakker;
	}
}
