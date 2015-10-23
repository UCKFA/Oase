package graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;

public class ImageLoader {

	private Display display;
	private File file;
	private ImagePanel currentImage;

	public ImageLoader() {

		display = Display.getInstance();
		display.getAddImage().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {
				setFile(chooseFile());

				try {
					loadImage(file);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}

	public void loadImage(BufferedImage img) {
		currentImage = new ImagePanel(img);
		DrawRoom.drawImage(currentImage);
		
	}

	public void loadImage(File f) throws IOException {
		currentImage = new ImagePanel(f);
		DrawRoom.drawImage(currentImage);
		
	}

	public File chooseFile() {

		JFileChooser fc = new JFileChooser();
		int f = fc.showOpenDialog(display.getAddImage());

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
