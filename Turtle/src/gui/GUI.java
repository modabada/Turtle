package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import camera.Cam;
import tray.TurtleTray;

public class GUI extends JFrame {
	private static final long serialVersionUID = 2941318999657277463L;
	public static final int WIDTH = 1024;
	public static final int HEIGHT = 768;

	private Panel_MenuBar menuPanel = new Panel_MenuBar(null, true, Color.lightGray, 0, 0, true);
	private Panel_Home homePanel = new Panel_Home(null, true, new Color(94, 126, 155), 0, 50, true);
	private Panel_Option optionPanel = new Panel_Option(null, true, new Color(171, 219, 235), 0, 50, true);

	public GUI(String title) {
		super(title);
		setSize(WIDTH, HEIGHT);// ������ ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ����� �޸� �Ҵ� ����
		setAlwaysOnTop(true);// �׻� ��
		setLayout(null);// ����� ���̾ƿ� ����
		setUndecorated(true);// �޴��� ����
		setLocationRelativeTo(null);// ȭ�� �߾ӿ��� ����
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("Turtle.png")));

		setup("Home");
		setVisible(true);// ������ ���ü� ON
	}

	public void setup(String cases) {
		add(menuPanel);
		switch (cases) {
		case "Home":
			remove(optionPanel);
			add(homePanel);
			break;
		case "Option":
			add(optionPanel);
			remove(homePanel);
			break;
		case "Running":
			new TurtleTray();
			new Cam();
			setVisible(false);
			break;
		}
		repaint();
	}

	void changeMnW(boolean state) {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		double width = dim.getWidth();
		double height = dim.getHeight();
		menuPanel.changeMnW(state, width, height);
		homePanel.changeMnW(state, width, height);
		optionPanel.changeMnW(state, width, height);
	}
}
