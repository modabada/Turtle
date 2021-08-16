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

import tray.FullTray.ShowMessageListener;

public class TurtleTray implements ActionListener{
	TrayIcon trayIcon;
	String title;
	String message;
	TrayIcon.MessageType messageType;
	
	public TurtleTray() {
		if (SystemTray.isSupported()) {
			final SystemTray tray = SystemTray.getSystemTray();
			Image image = Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("Turtle.png"));
			PopupMenu popup = new PopupMenu();
			final TrayIcon trayIcon = new TrayIcon(image, "Turtle", popup);
			MenuItem item = new MenuItem("���");
			
			item.addActionListener(new ShowMessageListener(trayIcon, "Title", "doc",
					TrayIcon.MessageType.WARNING));
			popup.add(item);
			item = new MenuItem("Close");
			item.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tray.remove(trayIcon);
				}
			});
			popup.add(item);
			try {
				tray.add(trayIcon);
			} catch (AWTException e) {
				System.err.println("Ʈ���̿� �߰��� �� �����ϴ�");
			}
		} else {
			System.err.println("Ʈ���̸� �������� �ʽ��ϴ�");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		trayIcon.displayMessage(title, message, messageType);
	}
}
