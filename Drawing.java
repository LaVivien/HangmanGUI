package project1;

import javax.swing.*;
import java.awt.*;

public class Drawing extends JPanel {
	static final long serialVersionUID = 42L;
	int n = 0;
	Shape shape;	
	
	public Drawing() {}
	
	public Drawing(Shape shape) {
		this.shape = shape;
	}
	
	public void redraw(int num) {
		n=num;
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {		
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		int startX = 0, startY = 0;
		int width=50, height=50;		
		for(int i=0;i<n;i++) {			
			g.fillRect(startX+(i*width)+(i-1)*5, startY, width, height);
		}
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(250, 250); 
	}
}
