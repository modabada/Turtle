package gui;

import java.awt.Color;
import java.awt.LayoutManager;

public class Panel_TitleContents extends Panel {
	private static final long serialVersionUID = -200163624877035206L;
	static final int WIDTH = 1024;
	static final int HEIGHT = 200;

	private Label_TitleText titleText = new Label_TitleText(null, false, null, 0, 0, WIDTH, HEIGHT, true);
	private Label_Turtle turtle1 = new Label_Turtle("Turtle.png", false, null, 80, 30, 150, 150, true);
	private Label_Turtle turtle2 = new Label_Turtle("Turtle.png", false, null, 794, 30, 150, 150, true);

	Panel_TitleContents(LayoutManager layout, Boolean isOpaque, Color color, int positionX, int positionY,
			boolean visible) {
		super(layout, isOpaque, color, positionX, positionY, WIDTH, HEIGHT, visible);

		add(turtle1);
		add(turtle2);
		add(titleText);
	}

	void setDoc(String doc) {
		titleText.setDoc(doc);
	}

	void removeTurtle() {
		remove(turtle1);
		remove(turtle2);
		repaint();
	}

	void changeMnW(boolean state, double width, double height) {
		double zoomWidth = state ? width / 1024 : 1;
		double zoomHeight = state ? height / 768 : 1;

		setBounds(X, (int) (Y * zoomHeight), (int) (WIDTH * zoomWidth), (int) (HEIGHT * zoomHeight));
		turtle1.changeMnW(state, width, height);
		turtle2.changeMnW(state, width, height);
		titleText.changeMnW(state, width, height);

	}

}
