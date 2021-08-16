package gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Btn_Exit extends Btn {
	private static final long serialVersionUID = 5116734508897397975L;

	Btn_Exit(String path, boolean isBorderPainted, boolean isContentAreaFilled, boolean isFocusPainted, int positionX,
			int positionY, int width, int height, boolean visible) {
		super(path, isBorderPainted, isContentAreaFilled, isFocusPainted, positionX, positionY, width, height,
				visible);

		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
	}

	@Override
	void changeMnW(boolean state, double width, double height) {
		setBounds((int) ((state ? width : 1024) - 40), Y, WIDTH, HEIGHT);
	}
}
