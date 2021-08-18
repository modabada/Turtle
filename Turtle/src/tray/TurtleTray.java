package tray;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import camera.Cam;

public class TurtleTray{
	public TurtleTray() {
		final SystemTray tray = SystemTray.getSystemTray();
		Image image = Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("Turtle.png"));
		PopupMenu popup = new PopupMenu();
		final TrayIcon trayIcon = new TrayIcon(image, "Turtle", popup);
		MenuItem item;
		
		if (SystemTray.isSupported()) {
			item = new MenuItem("경고");
			item.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					trayIcon.displayMessage("이상 자세가 감지되었습니다", "혹시 지금 얼굴을 너무 앞으로 내밀지는 않으셨나요?", TrayIcon.MessageType.WARNING);
				}
			});
			popup.add(item);
			
			item = new MenuItem("테스트");
			item.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					trayIcon.displayMessage("Debug",  "거북목 감지됨", TrayIcon.MessageType.INFO);
					trayIcon.displayMessage("Title",  "거북목 아님", TrayIcon.MessageType.INFO);
				}
			});
			popup.add(item);
			
			item = new MenuItem("Close");
			item.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			popup.add(item);
			try {
				tray.add(trayIcon);
				trayIcon.displayMessage("Title", "거북목 방지 프로그램이\n백그라운드에서 동작하고 있습니다", TrayIcon.MessageType.NONE);
			} catch (AWTException e) {
				System.err.println("트레이에 추가할 수 없습니다");
			}
		} else {
			System.err.println("트레이를 지원하지 않습니다");
		}
		
		// new Cam();
	}
}
