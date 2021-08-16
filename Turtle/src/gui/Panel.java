package gui;

import java.awt.Color;
import java.awt.LayoutManager;

import javax.swing.JPanel;

public abstract class Panel extends JPanel implements Components {
	private static final long serialVersionUID = -5929999569812055821L;
	final int X;
	final int Y;

	Panel(LayoutManager layout, Boolean isOpaque, Color color, int positionX, int positionY, int width, int height,
			boolean visible) {
		X = positionX;
		Y = positionY;
		setPanel(this, layout, isOpaque, color, X, Y, width, height, visible);
	}

	abstract void changeMnW(boolean state, double width, double heigth);
}
