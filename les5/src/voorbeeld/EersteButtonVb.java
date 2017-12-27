package voorbeeld;

import javax.swing.JButton;
import javax.swing.JFrame;

public class EersteButtonVb  extends JFrame {
     private JButton knop;
     private MijnButtonListener listener;
     
     public EersteButtonVb() {
    	 super("Mijn eerste GUI");
    	 
    	 this.knop = new JButton("Klik mij!");
    	 this.listener = new MijnButtonListener();
    	 this.knop.addActionListener(this.listener);
    	 
    	 this.getContentPane().add(this.knop);
    	 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	 this.pack();
     }
     
     public static void main(String[] args) {
		EersteButtonVb buttonVb = new EersteButtonVb();
		buttonVb.setVisible(true);
	}
}
