package gui;

import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import main.Main;

public class Btn_MaxAndWindow extends Btn {
	private static final long serialVersionUID = 8546018591330963504L;

	private Frame frame = GUI.getFrames()[0];
	private static boolean state = true;

	Btn_MaxAndWindow(String path, boolean isBorderPainted, boolean isContentAreaFilled, boolean isFocusPainted,
			int positionX, int positionY, int width, int height, boolean visible) {
		super(path, isBorderPainted, isContentAreaFilled, isFocusPainted, positionX, positionY, width, height,
				visible);

		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (state) {
					setIcon(getImageIcon("Window.png"));
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				} else {
					setIcon(getImageIcon("Maximize.png"));
					frame.setExtendedState(JFrame.NORMAL);
				}
				Main.gui.changeMnW(state);
				state = !state;

			}

		});
	}

	@Override
	void changeMnW(boolean state, double width, double height) {
		setBounds((int) ((state ? width : 1024) - 80), Y, WIDTH, HEIGHT);
	}

}
