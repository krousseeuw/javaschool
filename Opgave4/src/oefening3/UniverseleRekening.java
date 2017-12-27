package oefening3;

import java.util.ArrayList;
import java.util.Collections;

public class UniverseleRekening {
	private ArrayList<Volmachthouder> volmachthouders;
	
	public UniverseleRekening() {
		volmachthouders = new ArrayList<Volmachthouder>();
	}
	
	public boolean toevoegenVolmacht(Volmachthouder volmachthouder) {
		return volmachthouders.add(volmachthouder);
	}
	
	public boolean verwijderenVolmacht(Volmachthouder volmachthouder) 
	throws PersoonHeeftGeenVolmacht {
		if(volmachthouders.contains(volmachthouder))
			return volmachthouders.remove(volmachthouder);
		else
			throw new PersoonHeeftGeenVolmacht();
	}
	
	public boolean controleerVolmacht(Volmachthouder volmachthouder)
	throws PersoonHeeftGeenVolmacht{
		if(volmachthouders.contains(volmachthouder))
			return true;
		else
			throw new PersoonHeeftGeenVolmacht();
	}
	
	public ArrayList<Volmachthouder> geefVolmachthouders(){
		Collections.sort(volmachthouders);
		return volmachthouders;
	}
	
	public static void main(String[] args) {
		try {
		UniverseleRekening rekening = new UniverseleRekening();
		Volmachthouder vm1 = new Volmachthouder("Harlan", "Krueger");
		Volmachthouder vm2 = new Volmachthouder("Diath", "Woodrow");
		Volmachthouder vm3 = new Volmachthouder("Benjamin","Sisko");
		rekening.toevoegenVolmacht(vm1);
		rekening.toevoegenVolmacht(vm2);
		System.out.println(rekening.controleerVolmacht(vm2));
		//System.out.println(rekening.controleerVolmacht(vm3));
		rekening.toevoegenVolmacht(vm3);
		System.out.println(rekening.controleerVolmacht(vm3));
		for(Volmachthouder vm : rekening.geefVolmachthouders()) {
			System.out.println(vm.toString());
		}
		rekening.verwijderenVolmacht(vm1);
		for(Volmachthouder vm : rekening.geefVolmachthouders()) {
			System.out.println(vm.toString());
		}
		}
		catch (Exception e) {
			System.out.println("Exception occurred");						
		}		
	}
}