package gui;

import java.awt.Color;
import java.awt.Frame;
import java.awt.LayoutManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Panel_MenuBar extends Panel {
	private static final long serialVersionUID = 1205693586380174486L;
	static int WIDTH = 1024;
	static int HEIGHT = 50;

	private Frame frame = GUI.getFrames()[0];
	private int mouseX = 0;
	private int mouseY = 0;
	private boolean ismouseMotionListenerActive = true;

	private Btn_Exit exit = new Btn_Exit("Exit.png", false, false, false, 984, 10, 30, 30, true);
	private Btn_MaxAndWindow MnW = new Btn_MaxAndWindow("Maximize.png", false, false, false, 944, 10, 30, 30, true);
	private Btn_Minimize minimize = new Btn_Minimize("Minimize.png", false, false, false, 904, 10, 30, 30, true);

	Panel_MenuBar(LayoutManager layout, Boolean isOpaque, Color color, int positionX, int positionY,
			boolean visible) {
		super(layout, isOpaque, color, positionX, positionY, WIDTH, HEIGHT, visible);

		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				if (ismouseMotionListenerActive) {
					frame.setLocation(e.getXOnScreen() - mouseX, e.getYOnScreen() - mouseY);
				}
			}
		});

		add(exit);
		add(MnW);
		add(minimize);
	}

	void changeMnW(boolean state, double width, double height) {
		double zoomWidth = state ? width / 1024 : 1;

		setBounds(X, Y, (int) (WIDTH * zoomWidth), HEIGHT);
		ismouseMotionListenerActive = !state;
		exit.changeMnW(state, width, height);
		MnW.changeMnW(state, width, height);
		minimize.changeMnW(state, width, height);

	}

}
