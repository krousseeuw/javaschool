package oefening1;

import java.util.ArrayList;

import java.util.Collections;

import oefening1.Gewervelden.HuidType;
import oefening1.Ongewervelden.Kleur;

public class Dierentest {
	public static void main(String[] args) {
	
	ArrayList<Dier> dierlijst = new ArrayList<Dier>();
	Dier vleermuis = new Vleermuis("Gewone Grootoorvleermuis", (float) 0.05, HuidType.BEHAARD);
	Dier slang = new Slang("Zwarte Mamba", (float) 4, HuidType.SCHUBBEN);
	Dier gans = new Gans("Grote Canadese Gans", (float)1, HuidType.VEREN);
	Dier spons = new Boorspons("Spongebob Squarepants", Kleur.GEEL);
	Dier kikker = new Kikker("Johannes", 200, HuidType.VEL);
	dierlijst.add(vleermuis);
	dierlijst.add(slang);
	dierlijst.add(gans);
	dierlijst.add(spons);
	dierlijst.add(kikker);
	
	
	for(Dier dier : dierlijst) {
		System.out.println(dier.toString());
	}
	
	Collections.sort(dierlijst);
	
	for(Dier dier : dierlijst) {
		System.out.println(dier.toString());
	}
	
	}
}
