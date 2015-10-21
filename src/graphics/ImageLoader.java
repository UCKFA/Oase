package graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

public class ImageLoader {
	private Display display;
	private File file;
	byte[] imageBytes;


	public ImageLoader() {
		display.getInstance();
		Display.getAddImage().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setFile(chooseFile());
				try {
					loadImage();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}

	public byte[] loadImage() throws IOException {
		BufferedImage bufferedImage = ImageIO.read(file);
		WritableRaster raster = bufferedImage.getRaster();
		DataBufferByte data = (DataBufferByte) raster.getDataBuffer();
		
		return data.getData();
	}

	public File chooseFile() {

		JFileChooser file = new JFileChooser();

		Display.getMainFrame().add(file);
		
		file.setVisible(true);

		return file.getSelectedFile();

	}

	public File getFile() {
		return file;
	}

	public void setFile(File path) {
		this.file = path;
	}
}
