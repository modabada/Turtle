package tray;

import java.awt.AWTException;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FullTray{
	static class ShowMessageListener implements ActionListener {
		TrayIcon trayIcon;
		String title;
		String message;
		TrayIcon.MessageType messageType;

		ShowMessageListener(TrayIcon trayIcon, String title, String message, TrayIcon.MessageType messageType) {
			this.trayIcon = trayIcon;
			this.title = title;
			this.message = message;
			this.messageType = messageType;
		}

		public void actionPerformed(ActionEvent e) {
			trayIcon.displayMessage(title, message, messageType);
		}
	}

	public static void main(String args[]) {
		Runnable runner = new Runnable() {
			public void run() {
				if (SystemTray.isSupported()) {
					final SystemTray tray = SystemTray.getSystemTray();
					Image image = Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("Turtle.png"));
					PopupMenu popup = new PopupMenu();
					final TrayIcon trayIcon = new TrayIcon(image, "The Tip Text", popup);
					MenuItem item = new MenuItem("°æ°í");
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
						System.err.println("Can't add to tray");
					}
				} else {
					System.err.println("Tray unavailable");
				}
			}
		};
		EventQueue.invokeLater(runner);
	}
}