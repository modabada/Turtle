package gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Btn_Information extends Btn {
	private static final long serialVersionUID = -8927928044500206446L;

	Btn_Information(String path, boolean isBorderPainted, boolean isContentAreaFilled, boolean isFocusPainted,
			int positionX, int positionY, int width, int height, boolean visible, String tipText) {
		super(path, isBorderPainted, isContentAreaFilled, isFocusPainted, positionX, positionY, width, height,
				visible);

		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setIcon(getImageIcon("InformationBtn_onMouse.png"));
				createToolTip();

				setToolTipText(tipText);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				setIcon(getImageIcon("InformationBtn_Idle.png"));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				setIcon(getImageIcon("InformationBtn_onClick.png"));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				setIcon(getImageIcon("InformationBtn_onMouse.png"));
				System.out.println("Á¤º¸");
			}
		});
	}

	@Override
	void changeMnW(boolean state, double width, double height) {
		double zoomHeight = state ? height / 768 : 1;

		setBounds(X, (int) (zoomHeight * Y), WIDTH, HEIGHT);
	}
}
