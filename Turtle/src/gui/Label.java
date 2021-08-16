package gui;

import java.awt.Color;

import javax.swing.JLabel;

public abstract class Label extends JLabel implements Components {
	private static final long serialVersionUID = -665851987914481554L;
	final String PATH;
	final int WIDTH;
	final int HEIGHT;
	final int X;
	final int Y;

	Label(String path, Boolean isOpaque, Color color, int positionX, int positionY, int width, int height,
			boolean visible) {
		PATH = path;
		WIDTH = width;
		HEIGHT = height;
		X = positionX;
		Y = positionY;
		setLabel(this, PATH, isOpaque, color, X, Y, WIDTH, HEIGHT, visible);
	}

	abstract void changeMnW(boolean state, double width, double height);
}
