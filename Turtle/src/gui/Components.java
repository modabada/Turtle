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
		btn.setIcon(getImageIcon(path));// 이미지 설정
		btn.setBorderPainted(isBorderPainted);// 테두리 채색 안함
		btn.setContentAreaFilled(isContentAreaFilled);// 배경 채색 안함
		btn.setFocusPainted(isFocusPainted);// 포커스시 채색 안함
		btn.setVisible(visible);
	}

	default void setLabel(JLabel label, String path, Boolean isOpaque, Color color, int positionX, int positionY,
			int width, int height, boolean visible) {
		label.setBounds(positionX, positionY, width, height);// 레이블 레이아웃

		if (isOpaque) {
			label.setOpaque(isOpaque);
			label.setBackground(color);
			// 레이블 색상
		}

		if (path != null) {
			label.setIcon(getImageIcon(path));
		}

		label.setVisible(visible);// 레이블 가시성
	}

	default void setPanel(JPanel panel, LayoutManager layout, Boolean isOpaque, Color color, int positionX,
			int positionY, int width, int height, boolean visible) {
		panel.setBounds(positionX, positionY, width, height);
		panel.setLayout(layout);

		if (isOpaque) {
			panel.setOpaque(isOpaque);
			panel.setBackground(color);
			// 패널 색상
		}

		panel.setVisible(visible);
	}
}
