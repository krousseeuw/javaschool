package oefening2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class PowerSlider extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5441965737790836936L;
	private Thread thread;
	private int teller = 1;
	private JSlider slider;
	private volatile JTextField t;
	private volatile boolean check = true;
	
	public PowerSlider() {
		t = new JTextField("tekst");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		slider = new JSlider(1,100,1);
		this.add(slider, BorderLayout.NORTH);
		this.add(t, BorderLayout.CENTER);
		JButton start = new JButton("start");
		
		start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				thread = new Thread(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						check = true;
						while(check=true) {
							teller = teller + slider.getValue();
							t.setText(String.valueOf(teller));
							try {
								Thread.sleep(1000);
							} catch(InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				});
				
				thread.start();
			}
		});
		
		this.add(start, BorderLayout.WEST);
		
		JButton stop = new JButton("stop");
		stop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				check = false;
			}
		});
		
		this.add(stop, BorderLayout.EAST);
	}
}
