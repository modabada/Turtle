package gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import main.Main;

public class Btn_Option extends Btn {
	private static final long serialVersionUID = 3742821059067634938L;

	Btn_Option(String path, boolean isBorderPainted, boolean isContentAreaFilled, boolean isFocusPainted,
			int positionX, int positionY, int width, int height, boolean visible) {
		super(path, isBorderPainted, isContentAreaFilled, isFocusPainted, positionX, positionY, width, height,
				visible);

		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setIcon(getImageIcon("OptionBtn_onMouse.png"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				setIcon(getImageIcon("OptionBtn_Idle.png"));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				setIcon(getImageIcon("OptionBtn_onClick.png"));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				setIcon(getImageIcon("OptionBtn_onMouse.png"));
				Main.gui.setup("Option");
			}
		});
	}

	@Override
	void changeMnW(boolean state, double width, double height) {
		double zoomWidth = state ? width / 1024 : 1;
		double zoomHeight = state ? height / 768 : 1;
		setBounds((int) (zoomWidth * 1024 - 40), (int) (zoomHeight * Y), WIDTH, HEIGHT);
	}
}
