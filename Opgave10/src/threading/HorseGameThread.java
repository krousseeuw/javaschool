package threading;

import javax.swing.JSlider;

public class HorseGameThread implements Runnable {

	private JSlider horse;
	private Betting bet;
	
	public HorseGameThread(Betting bet, JSlider horse) {
		// TODO Auto-generated constructor stub
		this.bet = bet;
		this.horse = horse;
	}
	
	@Override
	public synchronized void run() {
		// TODO Auto-generated method stub
		while(horse.getValue()!=6437) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace(); 	
			}
			
			bet.runHorse(horse);
		}

	}

}
