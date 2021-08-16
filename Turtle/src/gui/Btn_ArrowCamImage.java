package gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Btn_ArrowCamImage extends Btn {
	private static final long serialVersionUID = -7773620777857303927L;

	Btn_ArrowCamImage(String path, boolean isGoRight, boolean isBorderPainted, boolean isContentAreaFilled,
			boolean isFocusPainted, int positionX, int positionY, int width, int height, boolean visible) {
		super(path, isBorderPainted, isContentAreaFilled, isFocusPainted, positionX, positionY, width, height,
				visible);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Panel_Option.camImage.setImage(isGoRight);
			}
		});
	}

	@Override
	void changeMnW(boolean state, double width, double height) {
		double zoomWidth = state ? width / 1024 : 1;
		double zoomHeight = state ? height / 768 : 1;

		setBounds((int) (X * zoomWidth), (int) (Y * zoomHeight), (int) (WIDTH * zoomWidth),
				(int) (HEIGHT * zoomHeight));
	}

}
