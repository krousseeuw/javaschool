package oefening3;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class InloggenGUI {
	private JFrame frame;
	
	private JPanel panel1, panel2, smallpanel1, smallpanel2;
	
	private JButton okButton, cancelButton;
	
	private JTextField textField;
	
	private JPasswordField passwordField;
	
	private Gebruikers gebruikers;
	
	public InloggenGUI() {
		gebruikers = new Gebruikers();
		gebruikers.toevoegen(new Persoon("Worf","1234"));
		gebruikers.toevoegen(new Persoon("Nightwing","1234"));
		getFrame();
	}
	
	public JFrame getFrame() {
		if(frame == null) {
			frame = new JFrame("Inloggen");
			Container c = frame.getContentPane();
			c.setLayout(new BorderLayout());
			c.add(getPanel1(), BorderLayout.NORTH);
			c.add(getPanel2(), BorderLayout.SOUTH);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.pack();
			frame.setResizable(false);
		}
		return frame;
	}

	public JPanel getPanel1() {
		if(panel1 == null) {
			panel1 = new JPanel();
			panel1.setLayout(new GridLayout(2, 1));
			panel1.add(getSmallPanel1());
			panel1.add(getSmallPanel2());			
		}
		return panel1;
	}

	public JPanel getPanel2() {
		if(panel2 == null) {
			panel2 = new JPanel();
			panel2.setLayout(new GridLayout(1, 2));
			panel2.add(getOkButton());
			panel2.add(getCancelButton());
		}
		return panel2;
	}

	public JButton getOkButton() {
		if(okButton == null) {
			okButton = new JButton("Ok");
			okButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(gebruikers.controle(new Persoon(getTextField()
							.getText(), new String(getPasswordField()
									.getPassword())))) {
						JOptionPane.showMessageDialog(frame, "Je bent ingelogd!", "Resultaat", JOptionPane.INFORMATION_MESSAGE);
						
						frame.dispose();
					} else {
						JOptionPane.showMessageDialog(frame, "Foutieve informatie!", "Resultaat", JOptionPane.INFORMATION_MESSAGE);
						getPasswordField().setText("");
						getPasswordField().requestFocus();
					}					
				}
			});
		}
		
		return okButton;
	}

	public JButton getCancelButton() {
		if(cancelButton==null) {
			cancelButton = new JButton("Cancel");
			cancelButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
				}
			});
		}
		return cancelButton;
	}
	
	public JTextField getTextField() {
		if(textField == null) {
			textField = new JTextField();
		}
		return textField;
	}

	public JPasswordField getPasswordField() {
		if(passwordField == null) {
			passwordField = new JPasswordField();
		}
		return passwordField;
	}

	public JPanel getSmallPanel1() {
		if(smallpanel1 == null) {
			smallpanel1 = new JPanel();
			smallpanel1.setLayout(new GridLayout(1, 2, 10, 10));
			smallpanel1.add(new JLabel("Gebruikersnaam:"));
			smallpanel1.add(getTextField());
		}
		return smallpanel1;
	}

	public JPanel getSmallPanel2() {
		if(smallpanel2 == null) {
			smallpanel2 = new JPanel();
			smallpanel2.setLayout(new GridLayout(1, 2, 10, 10));
			smallpanel2.add(new JLabel("Password"));
			smallpanel2.add(getPasswordField());
		}
		return smallpanel2;
	}

	public static void main(String[] args) {
		InloggenGUI inloggenGUI = new InloggenGUI();
		inloggenGUI.getFrame().setVisible(true);
	}
}
