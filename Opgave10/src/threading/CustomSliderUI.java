package threading;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.plaf.SliderUI;
import javax.swing.plaf.basic.BasicSliderUI;

public class CustomSliderUI extends BasicSliderUI {

	public CustomSliderUI(JSlider b) {
		super(b);
		// TODO Auto-generated constructor stub
	}

	public Dimension getThumbSize() {
		return new Dimension(25, 25);
	}
	
	@Override
	public void paintThumb(Graphics g) {
		// TODO Auto-generated method stub
		Image image = null;
		try {
			image = ImageIO.read(new File("horse.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		g.drawImage(image, thumbRect.x, thumbRect.y, 25, 25, null);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JSlider slider = new JSlider(0, 100);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMinorTickSpacing(5);
		slider.setMajorTickSpacing(25);
		slider.setUI(new CustomSliderUI(slider));
		frame.add(slider);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
