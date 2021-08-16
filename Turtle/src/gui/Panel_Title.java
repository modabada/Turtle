package gui;

import java.awt.Color;
import java.awt.LayoutManager;

public class Panel_Title extends Panel {
	private static final long serialVersionUID = 4823029436467486048L;
	static final int WIDTH = 1024;
	static final int HEIGHT = 250;

	private Panel_TitleContents titleContent = new Panel_TitleContents(null, true, new Color(171, 219, 235), 0, 25,
			true);

	Panel_Title(LayoutManager layout, Boolean isOpaque, Color color, int positionX, int positionY, boolean visible) {
		super(layout, isOpaque, color, positionX, positionY, WIDTH, HEIGHT, visible);

		add(titleContent);
	}

	void setDoc(String doc) {
		titleContent.setDoc(doc);
	}

	void removeTurtle() {
		titleContent.removeTurtle();
	}

	void changeMnW(boolean state, double width, double height) {
		double zoomWidth = state ? width / 1024 : 1;
		double zoomHeight = state ? height / 768 : 1;

		setBounds(X, Y, (int) (WIDTH * zoomWidth), (int) (HEIGHT * zoomHeight));
		titleContent.changeMnW(state, width, height);
	}
}
