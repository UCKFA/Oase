package graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;

public class ImageLoader {


	private File file;
	private ImagePanel currentImage;
	private static JMenuItem openButton;

	public ImageLoader() {

	}

	public void openImage() {
		try {
			setFile(chooseFile());
			loadImage(file);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void loadImage(BufferedImage img) {
		currentImage = new ImagePanel(img);
		DrawRoom.drawImage(currentImage);

	}

	public void loadImage(File f) throws IOException {
		currentImage = new ImagePanel(f);
		System.out.println(currentImage.getSize());
		DrawRoom.drawImage(currentImage);
		
	}

	public File chooseFile() {

		JFileChooser fc = new JFileChooser();
		int f = fc.showOpenDialog(openButton);

		if (f == JFileChooser.APPROVE_OPTION) {
			file = fc.getSelectedFile();

		}
		System.out.println(file.getAbsolutePath());
		return file;

	}

	public File getFile() {
		return file;
	}

	public void setFile(File path) {
		this.file = path;
	}

	public ImagePanel getCurrentImage() {
		return currentImage;
	}

	public void setCurrentImage(ImagePanel currentImage) {
		this.currentImage = currentImage;
	}

}
