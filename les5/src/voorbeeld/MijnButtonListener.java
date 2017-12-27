package voorbeeld;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MijnButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("De knop werd aangeklikt.");
	}	
}