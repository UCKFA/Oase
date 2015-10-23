package graphics;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
public class ImagePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5980300633668954251L;
	private BufferedImage img;
    public ImagePanel(){};
	
    public ImagePanel(BufferedImage img){
    	this.img = img;
    	this.setPreferredSize(new Dimension(1000, 500));
		this.setVisible(true);
    	
    }
    
	public ImagePanel(File f) throws IOException {
		img = createImage(f);
		this.setPreferredSize(new Dimension(1000, 500));
		this.setVisible(true);
		
	
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		
		g.drawImage(img, 0, 0, null);
	
	}

	private BufferedImage createImage(File file) throws IOException {
		BufferedImage bufferedImage = ImageIO.read(file);
		
		return bufferedImage;
	}

	public BufferedImage getImage() {
		return img;
	}

	public void setImage(BufferedImage img) {
		this.img = img;
	}
	
	

}
