package gui;

import java.awt.GridLayout;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import business.SorteerReservatieOpAanvang;
import db.FilmDAO;
import db.ReservatieDAO;
import db.ZaalDAO;
import entity.FilmVO;
import entity.ReservatieVO;
import entity.ZaalVO;

public class Klanten {
	private JFrame frame;
	
	public Klanten() {
		// TODO Auto-generated constructor stub
		frame = new JFrame();
		frame.setContentPane(new JPanel(new GridLayout(1, 0)));
		
		String[] columnName = {"Titel","Zaal","Aanvang","Einde",};
		
		ArrayList<ReservatieVO> reservatieVOs = new ReservatieDAO().selectAll();
		ArrayList<ZaalVO> zalen = new ZaalDAO().selectAll();
		FilmDAO filmDAO = new FilmDAO();
		HashSet<Integer> films = new HashSet<Integer>();
		HashMap<FilmVO, TreeSet<ReservatieVO>> filmreservatie = new HashMap<FilmVO, TreeSet<ReservatieVO>>();
		
		for (ReservatieVO item : reservatieVOs) {
			films.add(item.getFilmID());
		}
		
		for(Integer fItem : films) {
			TreeSet<ReservatieVO> flijst = new TreeSet<ReservatieVO>(new SorteerReservatieOpAanvang());
			
			for(ReservatieVO rItem : reservatieVOs) {
				if(rItem.getFilmID()==fItem) {
					flijst.add(rItem);
				}
			}
			filmreservatie.put(filmDAO.selectFilmWithID(fItem), flijst);
		}
		
		Object[][] o = new Object[reservatieVOs.size()][4];
		
		int teller = 0;
		
		for(FilmVO f:filmreservatie.keySet()) {
			for(ReservatieVO v:filmreservatie.get(f)) {
				o[teller][0]=f.getTitel();
				
				ZaalVO zaalVO = null;
				
				for(ZaalVO z : zalen) {
					if(z.getNummer() == v.getZaal()) {
						zaalVO = z;
						break;
					}
				}
				o[teller][1]=zaalVO.toString();
				
				SimpleDateFormat sdf=new SimpleDateFormat("hh:mm dd/MM/yy");
				Date d = v.getAanvang().getTime();
				o[teller][2]=sdf.format(d);
				Calendar c=Calendar.getInstance();
				c.setTime(d);
				c.add(Calendar.MINUTE, f.getDuur());
				o[teller][3]=sdf.format(c.getTime());
				teller++;
			}
		}
		
		final JTable table = new JTable(o, columnName);
		
		JScrollPane scrollPane = new JScrollPane(table);
		frame.getContentPane().add(scrollPane);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Klanten();	
	}
}
