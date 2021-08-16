package gui;

import javax.swing.JButton;

public abstract class Btn extends JButton implements Components {
	private static final long serialVersionUID = -952559457650155200L;
	final int WIDTH;
	final int HEIGHT;
	final int X;
	final int Y;

	Btn(String path, boolean isBorderPainted, boolean isContentAreaFilled, boolean isFocusPainted, int positionX,
			int positionY, int width, int height, boolean visible) {
		WIDTH = width;
		HEIGHT = height;
		X = positionX;
		Y = positionY;
		setButton(this, path, isBorderPainted, isContentAreaFilled, isFocusPainted, X, Y, WIDTH, HEIGHT, visible);
	}

	abstract void changeMnW(boolean state, double width, double height);

}
