package gui;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Label_Turtle extends Label {
	private static final long serialVersionUID = -7154721460733736473L;
	private ImageIcon image;

	Label_Turtle(String path, Boolean isOpaque, Color color, int positionX, int positionY, int width, int height,
			boolean visible) {
		super(path, isOpaque, color, positionX, positionY, width, height, visible);
		image = getImageIcon(PATH);

	}

	void changeMnW(boolean state, double width, double height) {
		double zoomWidth = state ? width / 1024 : 1;
		double zoomHeight = state ? height / 768 : 1;
		setBounds((int) (X * zoomWidth), (int) (Y * zoomHeight), (int) (WIDTH * zoomWidth),
				(int) (HEIGHT * zoomHeight));
		image = ImageIconResize(image, (int) (WIDTH * zoomWidth), (int) (HEIGHT * zoomHeight), Image.SCALE_SMOOTH);
		setIcon(image);
	}
}
