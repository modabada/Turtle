package gui;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import main.Main;

public class Btn_Start extends Btn {
	private static final long serialVersionUID = -8700444585506493272L;

	private ImageIcon[] image = { getImageIcon("StartBtn_Idle.png"), getImageIcon("StartBtn_onMouse.png"),
			getImageIcon("StartBtn_onClick.png") };

	Btn_Start(String path, boolean isBorderPainted, boolean isContentAreaFilled, boolean isFocusPainted,
			int positionX, int positionY, int width, int height, boolean visible) {
		super(path, isBorderPainted, isContentAreaFilled, isFocusPainted, positionX, positionY, width, height,
				visible);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setIcon(image[1]);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				setIcon(image[0]);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				setIcon(image[2]);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				setIcon(image[2]);
				Main.gui.setup("Running");
			}
		});
	}

	@Override
	void changeMnW(boolean state, double width, double height) {
		double zoomWidth = state ? width / 1024 : 1;
		double zoomHeight = state ? height / 768 : 1;

		setBounds((int) (X * zoomWidth), (int) (Y * zoomHeight), (int) (WIDTH * zoomWidth),
				(int) (HEIGHT * zoomHeight));
		for (int i = 0; i < 3; i++) {
			image[i] = ImageIconResize(image[i], (int) (WIDTH * zoomWidth), (int) (HEIGHT * zoomHeight),
					Image.SCALE_SMOOTH);
		}
		setIcon(image[0]);
	}
}
