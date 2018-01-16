package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import db.FilmDAO;
import db.ReservatieDAO;
import db.ZaalDAO;
import entity.FilmForCombobox;
import entity.FilmVO;
import entity.ReservatieVO;
import entity.ZaalVO;

public class BeheerderGui {
	
	private JFrame frame;
	private JTabbedPane tabs;
	private JPanel toevoegen, reserveren;
	private JTextField titel, duur, aanvang;
	private JButton filmToevoegen, reservatieToevoegen;
	private JComboBox<FilmForCombobox> films;
	private JComboBox<ZaalVO> zalen;

	public BeheerderGui() {
		getFrame().setVisible(true);
		getFrame().setResizable(false);
	}
	
	public JFrame getFrame() {
		if(frame==null) {
			frame = new JFrame();
			frame.add(getTabs());
			frame.pack();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
		return frame;
	}
	
	public JTabbedPane getTabs() {
		if(tabs==null) {
			tabs = new JTabbedPane();
			tabs.add("Film Toevoegen", getToevoegen());
			tabs.add("Reserveren", getReserveren());
			tabs.addChangeListener(new ChangeListener() {
				
				@Override
				public void stateChanged(ChangeEvent e) {
					// TODO Auto-generated method stub
					JTabbedPane sourceTabbedPane = (JTabbedPane)e.getSource();
					int index = sourceTabbedPane.getSelectedIndex();
					if(index == 1) {
						refreshFilms();
					}
				}
			});			
		}
		
		return tabs;
	}

	public JPanel getToevoegen() {
		if (toevoegen == null) {
			toevoegen = new JPanel(new GridLayout(3, 2, 5, 5));
			toevoegen.add(new JLabel("Titel:"));
			toevoegen.add(getTitel());
			toevoegen.add(new JLabel("Duur:"));
			toevoegen.add(getDuur());
			toevoegen.add(getFilmToevoegen());
		}
		
		return toevoegen;
	}
	
	public JPanel getReserveren() {
		if(reserveren == null) {
			reserveren = new JPanel(new GridLayout(4, 2, 5, 5));
			reserveren.add(new JLabel("Film:"));
			reserveren.add(getFilms());
			reserveren.add(new JLabel("Zaal:"));
			reserveren.add(getZalen());
			reserveren.add(new JLabel("Aanvang:"));
			reserveren.add(getAanvang());
			reserveren.add(getReservatieToevoegen());
		}
		
		return reserveren;
	}
	
	public JTextField getTitel() {
		if(titel==null) {
			titel = new JTextField(10);
		}
		
		return titel;
	}
	
	public JTextField getDuur() {
		if(duur==null) {
			duur = new JTextField(10);
		}
		
		return duur;
	}
	
	public JTextField getAanvang() {
		if(aanvang==null) {
			aanvang = new JTextField(10);
		}
		
		return aanvang;
	}
	
	public JButton getFilmToevoegen() {
		if(filmToevoegen == null) {
			filmToevoegen = new JButton("toevoegen");
			filmToevoegen.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					FilmDAO dao = new FilmDAO();
					
					if(!titel.getText().isEmpty()&&!duur.getText().isEmpty()) {
						try {
							int d = Integer.parseInt(duur.getText());
							FilmVO film = new FilmVO(d, titel.getText());
							dao.insert(film);
							clearFields();
						} catch(NumberFormatException e1) {
							JOptionPane.showMessageDialog(BeheerderGui.this.frame, "Geen geldige duur.", "Error", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(BeheerderGui.this.frame, "Een van de velden is leeg", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		}
		
		return filmToevoegen;
	}

	public JButton getReservatieToevoegen() {
		if(reservatieToevoegen == null) {
			reservatieToevoegen = new JButton("reserveren");
			reservatieToevoegen.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					ReservatieDAO dao = new ReservatieDAO();
					
					if(!aanvang.getText().isEmpty()) {
						try {
							SimpleDateFormat formatter = new SimpleDateFormat("hh:mm dd/MM/yy");
							Date date = (Date)formatter.parse(aanvang.getText());
							
							Calendar cal = Calendar.getInstance();
							cal.setTime(date);
							
							ReservatieVO reservatie = new ReservatieVO(((FilmForCombobox)films.getSelectedItem()).getID(), ((ZaalVO)zalen.getSelectedItem()).getNummer(), cal);
							dao.insert(reservatie);
							aanvang.setText("");
						} catch(ParseException e1) {
							JOptionPane.showMessageDialog(BeheerderGui.this.frame, "Geen geldige aanvang. Gebruik volgend formaat hh:mm  bv. 19:45", "Error", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(BeheerderGui.this.frame, "Aanvang is leeg.", "Error", JOptionPane.ERROR_MESSAGE );	
					}
				} 
			});
		}
		
		return reservatieToevoegen;
	}
	
	public JComboBox<FilmForCombobox> getFilms() {
		if(films == null) {
			films = new JComboBox<FilmForCombobox>();
			refreshFilms();
		}
		
		return films;
	}
	
	public JComboBox<ZaalVO> getZalen() {
		if(zalen == null) {
			zalen = new JComboBox<ZaalVO>();
			refreshZalen();
		}
		
		return zalen;
	}
	
	private void refreshZalen() {
		// TODO Auto-generated method stub
		zalen.removeAllItems();
		ZaalDAO dao = new ZaalDAO();
		
		for(ZaalVO item:dao.selectAll()) {
			zalen.addItem(item);
		}
	}

	protected void refreshFilms() {
		// TODO Auto-generated method stub
		films.removeAllItems();
		FilmDAO dao = new FilmDAO();
		
		for(FilmVO item:dao.selectAll()) {
			films.addItem(new FilmForCombobox(item));
		}
	}
	
	public void clearFields() {
		duur.setText("");
		titel.setText("");
	}
	
	public static void main(String[] args) {
		new BeheerderGui();
	}
}
