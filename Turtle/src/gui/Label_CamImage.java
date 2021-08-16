package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Label_CamImage extends Label implements DropTargetListener {
	private static final long serialVersionUID = 1370796864243669569L;
	private ImageIcon[] image = new ImageIcon[11];
	private ImageIcon loading = getImageIcon("Loading.gif");
	private int imageIndex = 1;
	private boolean state = false;

	Label_CamImage(String path, Boolean isOpaque, Color color, int positionX, int positionY, int width, int height,
			boolean visible) {
		super(path, isOpaque, color, positionX, positionY, width, height, visible);
		image[0] = getImageIcon("Unknown.png");
		for (int i = 1; i < image.length; i++) {
			image[i] = null;
		}

		new DropTarget(this, this);
		new File("./Resources/UserImage").mkdirs();
		for (int i = 1; i <= 10; i++) {
			File file = new File("./Resources/UserImage/UserImage" + i + ".png");
			if (file.exists()) {
				try {
					image[i] = new ImageIcon(
							ImageIO.read(new File("./Resources/UserImage/UserImage" + i + ".png")));
				} catch (Exception e) {
					for (; i <= 10; i++) {
						if (file.exists()) {
							file.delete();
						}
					}
				}
			}
		}
		changeMnW(state, 0, 0);
		setImage(false);
	}

	void setImage(boolean isGoRight) {
		if (image[1] == null) {
			setIcon(image[0]);
			return;
		}
		if (imageIndex >= image.length) {
			imageIndex = 10;
		}
		if (isGoRight) {
			if (++imageIndex >= image.length || image[imageIndex] == null) {
				imageIndex = 1;
			}
		} else {
			if (--imageIndex <= 0 || image[imageIndex] == null) {
				for (int i = 10; i > 0; i--) {
					if (image[i] != null) {
						imageIndex = i;
						break;
					}
				}
			}
		}
		setIcon(image[imageIndex]);
	}

	@Override
	void changeMnW(boolean state, double width, double height) {
		this.state = state;
		double zoomWidth = state ? width / 1024 : 1;
		double zoomHeight = state ? height / 768 : 1;

		setBounds((int) (X * zoomWidth), (int) (Y * zoomHeight), (int) (WIDTH * zoomWidth),
				(int) (HEIGHT * zoomHeight));
		for (int i = 0; i <= 10; i++) {
			if (image[i] == null) {
				break;
			}
			image[i] = ImageIconResize(image[i], (int) (WIDTH * zoomWidth), (int) (HEIGHT * zoomHeight),
					Image.SCALE_SMOOTH);
		}
		setImage(false);
	}

	@Override
	public void drop(DropTargetDropEvent event) {
		setIcon(loading);
		try {
			Transferable tr = event.getTransferable();
			if (tr.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
				event.acceptDrop(DnDConstants.ACTION_COPY);

				@SuppressWarnings("unchecked")
				List<Object> fileList = (List<Object>) tr.getTransferData(DataFlavor.javaFileListFlavor);
				File[] files = new File[fileList.size()];
				fileList.toArray(files);
				// 드롭된 파일 읽어오기 끝

				for (File file : files) {
					if (!file.getCanonicalPath().matches(".+((jpg)|(png))$")) {
						continue;
					}
					for (int i = 1; i <= 10; i++) {
						if (image[i] == null) {
							try (FileOutputStream fos = new FileOutputStream(
									new File("./Resources/UserImage/UserImage" + i + ".png"));) {
								Files.copy(file.toPath(), fos);
								image[i] = new ImageIcon(ImageIO.read(
										new File("./Resources/UserImage/UserImage" + i + ".png")));
								break;
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
				}
				imageIndex = 100;
				Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				changeMnW(state, dim.getWidth(), dim.getHeight());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void dragEnter(DropTargetDragEvent dtde) {
	}

	@Override
	public void dragOver(DropTargetDragEvent dtde) {
	}

	@Override
	public void dropActionChanged(DropTargetDragEvent dtde) {
	}

	@Override
	public void dragExit(DropTargetEvent dte) {
	}
}
