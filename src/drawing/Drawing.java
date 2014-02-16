package drawing;

public class Drawing {
	public static void main(String[] args) {
		Zen.create(800, 600);
		Zen.fillRect(0, 0, 800, 600);
		Zen.setColor(0, 0, 0);
		int prevX = 0;
		int prevY = 0;
		while(true) {
			int x = Zen.getMouseClickX();
			int y = Zen.getMouseClickY();
			Zen.fillOval(x -5, y -5, 10, 10);
			//Zen.drawLine(prevX, prevY, x, y);
			int fillers = Math.abs(x - prevX);
			for(int i = 0; i < fillers; i++) {
				if(x >= prevX) {
				Zen.fillOval(prevX + i - 5, y - 5, 10, 10);
			} else {
				Zen.fillOval(prevX - i - 5, y - 5, 10, 10);
			}
		}
			prevX = x;
			prevY = y;


		}
	}
}
