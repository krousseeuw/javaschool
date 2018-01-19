package gui;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.omg.CORBA.INITIALIZE;

import business.Klant;
import business.Klant4Combobox;

public class VideoApp extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 773986838844401829L;
	
	private JPanel jContentPane = null;
	
	private JComboBox<Klant4Combobox> jComboBox = null;
	
	private JTextArea jTextArea = null;
	
	public VideoApp() {
		super();
		initialize();
	}
	
	private void initialize() {
		this.setSize(300,200);
		this.setContentPane(getjContentPane());
		this.setTitle("Videotheek");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public JPanel getjContentPane() {
		if(jContentPane == null){
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getjComboBox(), BorderLayout.NORTH);
			jContentPane.add(getjTextArea(), BorderLayout.CENTER);			
		}
		
		return jContentPane;
	}
	
	public JTextArea getjTextArea() {
		if(jTextArea==null) {
			jTextArea = new JTextArea();
		}
		return jTextArea;
	}
	
	public JComboBox<Klant4Combobox> getjComboBox() {
		if(jComboBox == null) {
			jComboBox = new JComboBox<Klant4Combobox>();
			jComboBox.addItem(null);
			for(Klant x : Klant.getKlantenlijst()) {
				jComboBox.addItem(new Klant4Combobox(x));				
			}
			
			jComboBox.addItemListener(new java.awt.event.ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent e) {
					// TODO Auto-generated method stub
					if(jComboBox.getSelectedIndex()==-1) {
						jTextArea.setText("");
					} else if(e.getItem() instanceof Klant4Combobox) {
						jTextArea.setText(((Klant4Combobox)e.getItem()).getKlant().toString());
					}
				}				
			});
		}
		
		return jComboBox;		
	}
}