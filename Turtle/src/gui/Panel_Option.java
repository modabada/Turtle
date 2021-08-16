package gui;

import java.awt.Color;
import java.awt.LayoutManager;

public class Panel_Option extends Panel {
	private static final long serialVersionUID = 5803028956703878893L;
	static final int WIDTH = 1024;
	static final int HEIGHT = 768;

	private Panel_Title titlePanel = new Panel_Title(null, true, Color.darkGray, 0, 0, true);

	static Label_CamImage camImage = new Label_CamImage(null, true, Color.lightGray, 312, 285, 400, 400, true);

	private Btn_Home home = new Btn_Home("HomeBtn_Idle.png", false, false, false, 984, 30, 30, 30, true);
	private Btn_Information info = new Btn_Information("InformationBtn_Idle.png", false, false, false, 10, 30, 30, 30,
			true,
			"<html>ȭ�� �߾��� �̹����� �巡��&��� �Ͽ� ������ �߰��մϴ�<br>���� ����� Ȩ��ư�� ���� ó�� ȭ������ ���ư� �� �ֽ��ϴ�<br>ȭ��ǥ�� ���� ��ϵ� �������� �� �� �ֽ��ϴ�<br>������ �ִ� 10����� ����˴ϴ�<br>������ '���α׷�����/Resources/UserImage' �� ����˴ϴ�</html>");
	private Btn_ArrowCamImage arrowL = new Btn_ArrowCamImage("Arrow_L.png", false, false, false, false, 188, 427, 115,
			84, true);
	private Btn_ArrowCamImage arrowR = new Btn_ArrowCamImage("Arrow_R.png", true, false, false, false, 713, 427, 115,
			84, true);

	Panel_Option(LayoutManager layout, Boolean isOpaque, Color color, int positionX, int positionY, boolean visible) {
		super(layout, isOpaque, color, positionX, positionY, WIDTH, HEIGHT, visible);
		setDropTarget(getDropTarget());
		titlePanel.setDoc("ȯ�漳��");
		titlePanel.removeTurtle();

		add(info);
		add(home);
		add(titlePanel);
		add(camImage);
		add(arrowL);
		add(arrowR);

		repaint();
	}

	@Override
	void changeMnW(boolean state, double width, double height) {
		double zoomWidth = state ? width / 1024 : 1;
		double zoomHeight = state ? height / 768 : 1;

		setBounds(X, Y, (int) (WIDTH * zoomWidth), (int) (HEIGHT * zoomHeight));
		info.changeMnW(state, width, height);
		home.changeMnW(state, width, height);
		titlePanel.changeMnW(state, width, height);
		camImage.changeMnW(state, width, height);
		arrowL.changeMnW(state, width, height);
		arrowR.changeMnW(state, width, height);
	}
}
