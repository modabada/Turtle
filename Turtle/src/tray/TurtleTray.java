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
					trayIcon.displayMessage("Title", "doc", TrayIcon.MessageType.WARNING);
				}
			});
			popup.add(item);
			
			item = new MenuItem("Close");
			item.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					tray.remove(trayIcon);
				}
			});
			popup.add(item);
			try {
				tray.add(trayIcon);
			} catch (AWTException e) {
				System.err.println("트레이에 추가할 수 없습니다");
			}
		} else {
			System.err.println("트레이를 지원하지 않습니다");
		}
	}
}
