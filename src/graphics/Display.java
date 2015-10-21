package graphics;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Display {

	static private JFrame mainFrame;
	static private JButton addImage;
	static private Display instance;
	private Display(){}
	
	public Display getInstance(){
		if ( Display.instance == null )
			return new Display();
		else return Display.instance;
	}
	
	public void generateInitialWindow(){
		mainFrame= new JFrame();
		mainFrame.setSize(1000, 800);
		mainFrame.setVisible(true);
	}
	
	public void generateFileChooser(){
		addImage = new JButton("Load");
		addImage.setSize(50, 25);
		mainFrame.add(addImage);
		addImage.setVisible(true);
	}

	public static JFrame getMainFrame() {
		return mainFrame;
	}

	public static void setMainFrame(JFrame mainFrame) {
		Display.mainFrame = mainFrame;
	}

	public static JButton getAddImage() {
		return addImage;
	}

	public static void setAddImage(JButton addImage) {
		Display.addImage = addImage;
	}
	
}
