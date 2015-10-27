package graphics;


public class Display {

	private MainFrame mainFrame;
	private static Display instance = new Display();
	private ImageLoader imLoader;

	private Display() {
	}

	public static Display getInstance() {
		if (Display.instance == null)
			return new Display();
		else
			return Display.instance;
	}

	public void generateInitialWindow() {
		mainFrame = new MainFrame();
		mainFrame.setName("Oase");
		mainFrame.setVisible(true);
			
	}

	public void generateFileChooser() {
		imLoader = new ImageLoader();
		
	}

	public MainFrame getMainFrame() {
		return mainFrame;
	}

	public ImageLoader getImLoader() {
		return imLoader;
	}

	public void setImLoader(ImageLoader imLoader) {
		this.imLoader = imLoader;
	}
	
	public void setMainImagePanel(ImagePanel img){
		 mainFrame.setImagePanel(img);
	}
	
	public ImagePanel getMainImagePanel(){
		return mainFrame.getImagePanel();
	}

}
