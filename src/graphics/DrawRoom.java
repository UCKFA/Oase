package graphics;

public class DrawRoom implements Runnable {

	private Thread t;
	private static Display display = Display.getInstance();

	public DrawRoom() {

		start();

	}

	public static void drawImage(ImagePanel img) {
		if (display.getMainImagePanel().getImage() != null) {
			display.getMainFrame().remove(display.getMainImagePanel());
		}
		
		display.setMainImagePanel(img);
	

	}

	public void run() {

		while (true) {
			try {

				if (display.getMainImagePanel().getImage() != null) {
					display.getMainFrame().getContentPane().add(display.getMainImagePanel());
					display.getMainImagePanel().revalidate();
					display.getMainFrame().repaint();
				}
				Thread.sleep(300);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void start() {
		if (t == null)
			t = new Thread(this);

		t.start();

	}

}
