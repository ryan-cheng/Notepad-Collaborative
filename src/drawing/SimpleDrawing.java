package drawing;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class SimpleDrawing {
	
	static int red;
	static JTextField redInput;
	static int green;
	static JTextField greenInput;
	static int blue;
	static JTextField blueInput;
	
	public static void main(String[] args) {
		Zen.create(800, 600);
		Zen.fillRect(0, 0, 800, 600);
		Zen.connect("techlab-drawing");
		Zen.sleep(3000);
		makeColorChooser();
		
		Pen keshav = new Pen("keshav");
		Pen ojas = new Pen("ojas");
		
		Zen.setColor(0, 0, 0);
		int prevX = 0;
		int prevY = 0;
		long prevTime = 0;
		boolean mouseClicked = false;
		while(true) {
			int x = Zen.getMouseClickX();
			int y = Zen.getMouseClickY();
			checkToolbar(x,y);
			Zen.write("ryanx", x);
			Zen.write("ryany", y);
			Zen.write("ryanred", red);
			Zen.write("ryangreen", green);
			Zen.write("ryanblue", blue);
			
			
			
			if(mouseClicked) {
				Zen.write("ryandown", 1);
			}
			
			else {
				Zen.write("ryandown", 0);
			}
			
			if (mouseClicked) {
				Zen.drawLine(prevX, prevY, x, y);
			}
			if(prevTime != Zen.getMouseClickTime()) {
				mouseClicked = true;
			}
			else {
				mouseClicked = false;
			}
			
			keshav.move();
			keshav.draw();
			ojas.move();
			ojas.draw();
			
			prevX = x;
			prevY = y;
			prevTime = Zen.getMouseClickTime();
			Zen.sleep(33);
		}
	}

	private static void checkToolbar(int x, int y) {
		if(Zen.isVirtualKeyPressed(KeyEvent.VK_BACK_SPACE)) {
			Zen.setColor(255, 255, 255);
			Zen.fillRect(0, 0, 800, 600);
		}
		Zen.setColor(red, green, blue);
	}

	private static void makeColorChooser() {
		JFrame colorChooser = new JFrame("color picker");
		colorChooser.setSize(200,200);
		colorChooser.setLayout(new GridLayout(4,1));
		redInput = new JTextField(10);
		greenInput = new JTextField(10);
		blueInput = new JTextField(10);
		JButton button = new JButton("change color");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				red = Integer.parseInt(redInput.getText());
				green = Integer.parseInt(greenInput.getText());
				blue = Integer.parseInt(blueInput.getText());
			}
		});
		colorChooser.add(redInput);
		colorChooser.add(greenInput);
		colorChooser.add(blueInput);
		colorChooser.add(button);
		colorChooser.setVisible(true);
	}
}