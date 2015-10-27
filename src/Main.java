import graphics.Display;
import graphics.DrawRoom;


public class Main {
	
	private static Display display;
	
	
	public static void main(String[] args) {
		display = Display.getInstance();
		display.generateInitialWindow();
		display.generateFileChooser();
	

		DrawRoom drawRoom = new DrawRoom();
	}
	
}
