package gui;

import java.awt.Color;
import java.awt.Font;

public class Label_TitleText extends Label {
	private static final long serialVersionUID = 3445706182019343117L;

	Label_TitleText(String path, Boolean isOpaque, Color color, int positionX, int positionY, int width, int height,
			boolean visible) {
		super(path, isOpaque, color, positionX, positionY, width, height, visible);
	}

	public void setDoc(String doc) {
		setFont(new Font("Noto Serif CJK KR", Font.BOLD, 72));
		setHorizontalAlignment(Label.CENTER);
		setVerticalAlignment(Label.CENTER);
		setText(doc);
	}

	@Override
	void changeMnW(boolean state, double width, double height) {
		double zoomWidth = state ? width / 1024 : 1;
		double zoomHeight = state ? height / 768 : 1;

		setBounds((int) (X * zoomWidth), (int) (Y * zoomHeight), (int) (WIDTH * zoomWidth),
				(int) (HEIGHT * zoomHeight));
		setFont(new Font(getFont().toString(), Font.BOLD, (int) (72 * zoomHeight)));
	}
}
