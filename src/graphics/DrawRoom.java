package graphics;

public class DrawRoom implements Runnable {

	private Thread t;
	private static Display display = Display.getInstance();

	public DrawRoom() {

		start();

	}

	public static void drawImage(ImagePanel img) {
		if (display.getImagePanel() != null) {
			display.getMainFrame().remove(display.getImagePanel());
		}
		display.setImagePanel(img);

	}

	public void run() {

		while (true) {
			try {

				if (display.getImagePanel() != null) {
					display.getMainFrame().getContentPane().add(display.getImagePanel());
					display.getImagePanel().revalidate();
					display.getMainFrame().repaint();
				}

				System.out.println("rUNNING");
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
