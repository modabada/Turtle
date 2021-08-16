package gui;

import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Btn_Minimize extends Btn {
	private static final long serialVersionUID = -164931057258595727L;
	private Frame frame = GUI.getFrames()[0];

	Btn_Minimize(String path, boolean isBorderPainted, boolean isContentAreaFilled, boolean isFocusPainted,
			int positionX, int positionY, int width, int height, boolean visible) {
		super(path, isBorderPainted, isContentAreaFilled, isFocusPainted, positionX, positionY, width, height,
				visible);

		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setState(Frame.ICONIFIED);
			}
		});
	}

	@Override
	void changeMnW(boolean state, double width, double height) {
		setBounds((int) ((state ? width : 1024) - 120), Y, WIDTH, HEIGHT);
		;
	}
}
