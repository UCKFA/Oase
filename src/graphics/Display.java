package graphics;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Display {

    private JFrame mainFrame;
    private ImagePanel imagePanel;
	private JButton addImage;
	private JButton applyFilter;
	private static  Display instance = new Display();
	private ImageLoader imLoader;
	private Display(){}
	
	public static Display getInstance(){
		if ( Display.instance == null )
			return new Display();
		else return Display.instance;
	}
	
	public void generateInitialWindow(){
		mainFrame= new JFrame("Oase");
		mainFrame.setLayout(new FlowLayout());
		mainFrame.setSize(1000, 800);
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void generateFileChooser(){
		addImage = new JButton("Load");
		addImage.setSize(150, 25);
		mainFrame.add(addImage);
		addImage.setVisible(true);
	    imLoader= new ImageLoader();
	}
	
	public void generateFilterButton(){
		applyFilter = new JButton("ApplyFilter");
		applyFilter.setSize(150, 25);
		mainFrame.add(applyFilter);
		applyFilter.setVisible(true);
		
		applyFilter.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				DrawRoom.drawImage(new ImagePanel(SobelFilter.applyFilter(imLoader.getCurrentImage())));
				
			}
		});
		
	}
	
	public  JFrame getMainFrame() {
		return mainFrame;
	}

	public  void setMainFrame(JFrame mainFrame) {
		getInstance().mainFrame = mainFrame;
	}

	public  JButton getAddImage() {
		return addImage;
	}

	public  void setAddImage(JButton addImage) {
		getInstance().addImage = addImage;
	}

	public JButton getApplyFilter() {
		return applyFilter;
	}

	public void setApplyFilter(JButton applyFilter) {
		this.applyFilter = applyFilter;
	}

	public ImageLoader getImLoader() {
		return imLoader;
	}

	public void setImLoader(ImageLoader imLoader) {
		this.imLoader = imLoader;
	}

	public ImagePanel getImagePanel() {
		return imagePanel;
	}

	public void setImagePanel(ImagePanel imagePanel) {
		this.imagePanel = imagePanel;
	}
	
	
	
}
