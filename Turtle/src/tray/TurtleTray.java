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
			item = new MenuItem("���");
			item.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					trayIcon.displayMessage("�̻� �ڼ��� �����Ǿ����ϴ�", "Ȥ�� ���� ���� �ʹ� ������ �������� �����̳���?", TrayIcon.MessageType.WARNING);
				}
			});
			popup.add(item);
			
			item = new MenuItem("�׽�Ʈ");
			item.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					trayIcon.displayMessage("Debug",  "�źϸ� ������", TrayIcon.MessageType.INFO);
					trayIcon.displayMessage("Title",  "�źϸ� �ƴ�", TrayIcon.MessageType.INFO);
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
				trayIcon.displayMessage("Title", "�źϸ� ���� ���α׷���\n��׶��忡�� �����ϰ� �ֽ��ϴ�", TrayIcon.MessageType.NONE);
			} catch (AWTException e) {
				System.err.println("Ʈ���̿� �߰��� �� �����ϴ�");
			}
		} else {
			System.err.println("Ʈ���̸� �������� �ʽ��ϴ�");
		}
		
		// new Cam();
	}
}
