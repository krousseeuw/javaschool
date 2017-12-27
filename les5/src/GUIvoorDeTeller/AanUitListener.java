package GUIvoorDeTeller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class AanUitListener implements ActionListener{
	private Teller tel;
	private JTextField display;
	
	public AanUitListener(Teller tel, JTextField display) {
		this.tel=tel;
		this.display=display;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.tel.setTellerStaatAan(!this.tel.staatTellerAan());
		this.display.setText(Integer.toString(this.tel.getWaarde()));
	}
}
