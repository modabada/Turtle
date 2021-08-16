package gui;

import java.awt.Color;
import java.awt.LayoutManager;

public class Panel_Home extends Panel {
	private static final long serialVersionUID = 7446908322419174696L;
	static final int WIDTH = 1024;
	static final int HEIGHT = 768;

	private Panel_Title titlePanel = new Panel_Title(null, true, Color.darkGray, 0, 0, true);

	private Btn_Start startBtn = new Btn_Start("StartBtn_Idle.png", false, false, false, 312, 450, 400, 162, true);
	private Btn_Option option = new Btn_Option("OptionBtn_Idle.png", false, false, false, 984, 30, 30, 30, true);
	private Btn_Information info = new Btn_Information("InformationBtn_Idle.png", false, false, false, 10, 30, 30, 30,
			true, "<html>우측상단의 옵션으로 사용자의 사진을 설정할 수 있습니다<br>시작버튼을 통해 프로그램을 시작합니다</html>");

	Panel_Home(LayoutManager layout, Boolean isOpaque, Color color, int positionX, int positionY, boolean visible) {
		super(layout, isOpaque, color, positionX, positionY, WIDTH, HEIGHT, visible);
		titlePanel.setDoc("거북목 방지");

		add(option);
		add(info);
		add(titlePanel);
		add(startBtn);
		repaint();
	}

	void changeMnW(boolean state, double width, double height) {
		double zoomWidth = state ? width / 1024 : 1;
		double zoomHeight = state ? height / 768 : 1;

		setBounds(X, Y, (int) (WIDTH * zoomWidth), (int) (HEIGHT * zoomHeight));
		option.changeMnW(state, width, height);
		info.changeMnW(state, width, height);
		titlePanel.changeMnW(state, width, height);
		startBtn.changeMnW(state, width, height);
	}
}
