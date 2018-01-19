package ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.imageio.ImageTypeSpecifier;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import entity.Bakker;
import entity.Product;
import entity.Taart;

public class BakkerGUI  {
	private JFrame frame;
	private JPanel panel, leftPanel, rightPanel;
	private JLabel naamLabel, prijsLabel;
	private JComboBox<Bakker> bakkerCombobox;
	private JTextField naamTextfield, prijsTextField;
	private JButton toevoegenButton, verwijderenButton;
	private JTabbedPane tabs;
	
	public BakkerGUI() {
		getFrame().setVisible(true);
	}
	
	public JFrame getFrame() {
		if(frame==null) {
			frame = new JFrame("Bakkersysteem");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.add(getPanel());
			frame.pack();
		}
		return frame;
	}
	
	
	
	public JPanel getPanel() {
		if(panel == null) {
			panel = new JPanel();
			panel.setLayout(new GridLayout(2, 2));
			panel.add(getLeftPanel());
			panel.add(getRightPanel());
			panel.add(getToevoegenButton());
			panel.add(getVerwijderenButton());
		}
			
		return panel;
	}
	
	public JPanel getLeftPanel() {
		if(leftPanel==null) {
			leftPanel = new JPanel();
			leftPanel.setLayout(new GridLayout(2, 2));
			leftPanel.add(getNaamLabel());
			leftPanel.add(getNaamTextfield());
			leftPanel.add(getPrijsLabel());
			leftPanel.add(getPrijsTextField());			
		}
		
		return leftPanel;
	}
	
	public JPanel getRightPanel() {
		if(rightPanel==null) {
			rightPanel = new JPanel();
			rightPanel.setLayout(new GridLayout(1, 1));
			rightPanel.add(getBakkerCombobox());
		}
		
		return rightPanel;
	}
	
	public JLabel getNaamLabel() {
		if(naamLabel == null) {
			naamLabel = new JLabel("Naam");			
		}
		return naamLabel;
	}
	
	public JLabel getPrijsLabel() {
		if(prijsLabel == null) {
			prijsLabel = new JLabel("Prijs");			
		}
		return prijsLabel;
	}
	
	public JComboBox<Bakker> getBakkerCombobox() {
		if(bakkerCombobox == null) {
			bakkerCombobox = new JComboBox<Bakker>();
			refreshBakkers();
		}
		return bakkerCombobox;
	}

	private void refreshBakkers() {
		getBakkerCombobox().removeAllItems();
		for(Bakker bakker : Bakker.bakkerlijst) {
			bakkerCombobox.addItem(bakker);
		}
	}

	public JTextField getNaamTextfield() {
		if(naamTextfield==null) {
			naamTextfield = new JTextField();
		}
		return naamTextfield;
	}
	
	public JTextField getPrijsTextField() {
		if(prijsTextField==null) {
			prijsTextField = new JTextField();
		}
		return prijsTextField;
	}
	
	public JButton getToevoegenButton() {
		if(toevoegenButton ==null) {
			toevoegenButton = new JButton("Toevoegen");
			toevoegenButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Product taart = new Taart();
					taart.setNaam(getNaamTextfield().getText());
					taart.setPrijs(Integer.parseInt(getPrijsTextField().getText()));
					((Bakker)getBakkerCombobox().getSelectedItem()).voegProductToe(taart);
					clearFields();
				}
			});
		}
		return toevoegenButton;
	}
	
	protected void clearFields() {
		getNaamTextfield().setText("");
		getPrijsTextField().setText("");
		
	}

	public JButton getVerwijderenButton() {
		if(verwijderenButton == null) {
			verwijderenButton = new JButton("Verwijderen");
			verwijderenButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Bakker bakker = (Bakker) getBakkerCombobox().getSelectedItem();
					Bakker.bakkerlijst.remove(bakker);
					refreshBakkers();
				}
			});
		}
		return verwijderenButton;
	}

	
	public static void main(String[] args) {
		Bakker bakker1 = new Bakker("Lul", 10);
		Bakker bakker2 = new Bakker("Scheet", 12);
		new BakkerGUI();
	}
}
