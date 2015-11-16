package procedure;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import graphics.Display;
import graphics.ImagePanel;

public class MainProc {
	BackProc back = new BackProc();
	SideProc side = new SideProc();
	Display display = Display.getInstance();
	ImagePanel image;
	
	public MainProc(){
		this.image = display.getMainFrame().getImagePanel();
		MouseListener listener = new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseClicked(MouseEvent e) {
				drawCircle( e.getX() , e.getY() );
			}
		};
		image.addMouseListener(listener);
	}
	
	public void drawCircle( int x , int y ){
		System.out.println("Drawing circle to " + x + "/" + y);
	}
	
	public BufferedImage selectLeftShoulder( BufferedImage image ){
		return image;
		
	}
	
}
