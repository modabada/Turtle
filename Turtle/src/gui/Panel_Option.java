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
			"<html>화면 중앙의 이미지에 드래그&드랍 하여 파일을 추가합니다<br>우측 상단의 홈버튼을 통해 처음 화면으로 돌아갈 수 있습니다<br>화살표를 통해 등록된 사진들을 볼 수 있습니다<br>사진은 최대 10장까지 저장됩니다<br>사진은 '프로그램폴더/Resources/UserImage' 에 저장됩니다</html>");
	private Btn_ArrowCamImage arrowL = new Btn_ArrowCamImage("Arrow_L.png", false, false, false, false, 188, 427, 115,
			84, true);
	private Btn_ArrowCamImage arrowR = new Btn_ArrowCamImage("Arrow_R.png", true, false, false, false, 713, 427, 115,
			84, true);

	Panel_Option(LayoutManager layout, Boolean isOpaque, Color color, int positionX, int positionY, boolean visible) {
		super(layout, isOpaque, color, positionX, positionY, WIDTH, HEIGHT, visible);
		setDropTarget(getDropTarget());
		titlePanel.setDoc("환경설정");
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
