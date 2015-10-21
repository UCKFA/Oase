import graphics.Display;


public class Main {
	
	private static Display display;
	
	public static void main(String[] args) {
		display = display.getInstance();
		display.generateInitialWindow();
		display.generateFileChooser();
	}
	
}
