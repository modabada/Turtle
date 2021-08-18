package camera;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Timer;
import java.util.TimerTask;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;

public class Cam {
	static {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	}
	VideoCapture cam;
	Mat img = new Mat();
	Timer timer = new Timer();
	TimerTask timeTask = new TimerTask() {
		@Override
		public void run() {
			cam.read(img);
			saveImage();
		}
	};

	public Cam() {
		cam = new VideoCapture(0);
		cam.set(Videoio.CAP_PROP_FRAME_WIDTH, 320);
		cam.set(Videoio.CAP_PROP_FRAME_HEIGHT, 180);

		if (!cam.isOpened()) {
			System.out.println("Eror");
			System.exit(1);
		}

		timer.schedule(timeTask, 0, 4000);
	}

	public void saveImage() {
		new File("./Resources/temp").mkdirs();
		String file = "./Resources/temp/test.jpg";
		Imgcodecs.imwrite(file, img);
	}

	public void sendPython() throws Exception {
		String command = "C:\\Users\\inwoo\\anaconda3\\envs\\PY_AI\\python.exe"; // 명령어
		String arg1 = "./loadModel.py"; // 인자
		ProcessBuilder builder = new ProcessBuilder(command, arg1);
		Process process = builder.start();
		int exitVal = process.waitFor(); // 자식 프로세스가 종료될 때까지 기다림
		if (exitVal != 0) {
			throw new Exception();
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream(), "euc-kr")); // 서브 프로세스가
																											// 출력하는 내용을
																											// 받기 위해
		if (br.readLine() == "[1]") {
			System.out.println("거북목");
		} else if (br.readLine() == "[0]") {
			System.out.println("거북목 아님");
		} else {
			System.out.println(br.readLine());
		}

	}
}
