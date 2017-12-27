package oefening1;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Labels {
	private JFrame jFrame;
	
	private JLabel label1;
	private JLabel label2;
	
	public Labels() {
		getJFrame().setVisible(true);
	}

	/**
	 * this method initializes a jFrame
	 * 
	 * @return javax.swing.JFrame
	 */
	private JFrame getJFrame() {
		if(jFrame==null) {
			jFrame=new JFrame();
			jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			jFrame.setSize(300, 200);
			
			Container c = jFrame.getContentPane();
			c.setLayout(new FlowLayout());
			
			c.add(getLabel1());
			c.add(getLabel2());
			
			jFrame.setTitle("Application");
		}		
		return jFrame;
	}

	private JLabel getLabel1() {
		if(this.label1==null) {
			this.label1 = new JLabel();
			
			this.label1.setText("label1");
		}
		return this.label1;
	}
	
	private JLabel getLabel2() {
		if(this.label2==null) {
			this.label2 = new JLabel();
			this.label2.setText("label2");
			this.label2.setBackground(Color.RED);
			this.label2.setOpaque(true);
		}
		return this.label2;
	}
	
	public static void main(String[] args) {
		new Labels();
	}
}
