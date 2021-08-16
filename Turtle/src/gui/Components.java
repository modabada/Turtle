package gui;

import java.awt.Color;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public interface Components {
	default Image getImage(String path) {
		return Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource(path));
	}

	default ImageIcon getImageIcon(String path) {
		return new ImageIcon(getImage(path));
	}
	
	default Image ImageResize(Image image, int width, int height,int mode) {
		return image.getScaledInstance(width, height, mode);
	}
	
	default ImageIcon ImageIconResize(ImageIcon imageIcon, int width, int height, int mode) {
		return new ImageIcon(imageIcon.getImage().getScaledInstance(width, height, mode));
	}

	default void setButton(JButton btn, String path, boolean isBorderPainted, boolean isContentAreaFilled,
			boolean isFocusPainted, int positionX, int positionY, int width, int height, boolean visible) {
		btn.setBounds(positionX, positionY, width, height);
		btn.setIcon(getImageIcon(path));// �̹��� ����
		btn.setBorderPainted(isBorderPainted);// �׵θ� ä�� ����
		btn.setContentAreaFilled(isContentAreaFilled);// ��� ä�� ����
		btn.setFocusPainted(isFocusPainted);// ��Ŀ���� ä�� ����
		btn.setVisible(visible);
	}

	default void setLabel(JLabel label, String path, Boolean isOpaque, Color color, int positionX, int positionY,
			int width, int height, boolean visible) {
		label.setBounds(positionX, positionY, width, height);// ���̺� ���̾ƿ�

		if (isOpaque) {
			label.setOpaque(isOpaque);
			label.setBackground(color);
			// ���̺� ����
		}

		if (path != null) {
			label.setIcon(getImageIcon(path));
		}

		label.setVisible(visible);// ���̺� ���ü�
	}

	default void setPanel(JPanel panel, LayoutManager layout, Boolean isOpaque, Color color, int positionX,
			int positionY, int width, int height, boolean visible) {
		panel.setBounds(positionX, positionY, width, height);
		panel.setLayout(layout);

		if (isOpaque) {
			panel.setOpaque(isOpaque);
			panel.setBackground(color);
			// �г� ����
		}

		panel.setVisible(visible);
	}
}
