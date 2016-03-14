package com.oase.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

import com.oase.graphics.InterestPoint;
import com.oase.procedures.MainProc;

/**
 * 
 * @author Brinzi's
 */
public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5064614312634563408L;
	/**
	 * Creates new form MainFrame
	 */

	// Variables declaration - do not modify
	private JMenuItem aboutOption;
	private JPanel analisisPanel;
	private JButton analyzeButton;
	private JMenu editMenu;
	private JMenuItem exitOption;
	private JMenu fileMenu;
	private JMenu helpMenu;
	private ImagePanel imagePanel;
	private JMenuItem jMenuItem1;
	private JScrollPane jScrollPane1;
	private JTextArea reportScreen;
	private JMenuBar menuBar;
	private JMenuItem openOption;
	private JMenuItem saveAsOption;
	private JMenuItem saveOption;

	// End of variables declaration

	public MainFrame() {
		initComponents();
	}

	private void initComponents() {

		imagePanel = new ImagePanel();
		analisisPanel = new JPanel();
		jScrollPane1 = new JScrollPane();
		reportScreen = new JTextArea("Please open image...");
		analyzeButton = new JButton();
		menuBar = new JMenuBar();
		fileMenu = new JMenu();
		openOption = new JMenuItem();
		saveOption = new JMenuItem();
		saveAsOption = new JMenuItem();
		exitOption = new JMenuItem();
		editMenu = new JMenu();
		jMenuItem1 = new JMenuItem();
		helpMenu = new JMenu();
		aboutOption = new JMenuItem();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Oase");
		setSize(900, 700);

		GroupLayout imagePanelLayout = new GroupLayout(imagePanel);
		imagePanel.setLayout(imagePanelLayout);
		imagePanel.setPreferredSize(new Dimension(800, 500));
		imagePanelLayout.setHorizontalGroup(imagePanelLayout
				.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0,
						800, Short.MAX_VALUE));
		imagePanelLayout.setVerticalGroup(imagePanelLayout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGap(0, 0, Short.MAX_VALUE));

		reportScreen.setColumns(20);
		reportScreen.setRows(5);
		reportScreen.setEditable(false);
		jScrollPane1.setViewportView(reportScreen);

		GroupLayout analisisPanelLayout = new GroupLayout(analisisPanel);
		analisisPanel.setLayout(analisisPanelLayout);
		analisisPanelLayout.setHorizontalGroup(analisisPanelLayout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 294,
						Short.MAX_VALUE));
		analisisPanelLayout.setVerticalGroup(analisisPanelLayout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 391,
						Short.MAX_VALUE));

		analyzeButton.setText("Analyze");

		fileMenu.setText("File");

		openOption.setAccelerator(KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_O,
				java.awt.event.InputEvent.CTRL_MASK));
		openOption.setText("Open");
		openOption.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				MenuActions.open();
				
			}
		});
		
		fileMenu.add(openOption);

		saveOption.setAccelerator(KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_S,
				java.awt.event.InputEvent.CTRL_MASK));
		saveOption.setText("Save");
		fileMenu.add(saveOption);

		saveAsOption.setAccelerator(KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_S,
				java.awt.event.InputEvent.ALT_MASK
						| java.awt.event.InputEvent.CTRL_MASK));
		saveAsOption.setText("Save As");
	
		fileMenu.add(saveAsOption);

		exitOption.setAccelerator(KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_F4,
				java.awt.event.InputEvent.ALT_MASK));
		exitOption.setText("Exit");
		fileMenu.add(exitOption);

		menuBar.add(fileMenu);

		editMenu.setText("Edit");

		jMenuItem1.setText("toDo..");
		editMenu.add(jMenuItem1);

		menuBar.add(editMenu);

		helpMenu.setText("Help");

		aboutOption.setText("About");
		helpMenu.add(aboutOption);

		menuBar.add(helpMenu);

		setJMenuBar(menuBar);

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addComponent(imagePanel,
										GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.LEADING)
												.addComponent(
														analyzeButton,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(
														analisisPanel,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE))));
		layout.setVerticalGroup(layout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(imagePanel, GroupLayout.DEFAULT_SIZE,
						GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(
						layout.createSequentialGroup()
								.addComponent(analisisPanel,
										GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(analyzeButton,
										GroupLayout.DEFAULT_SIZE, 82,
										Short.MAX_VALUE)));

		pack();
		
		analyzeButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
						
				MainProc.analyze();
			}
		});
		
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
				MainProc.mainProc( e.getX() , e.getY());
				imagePanel.drawCircle( e.getX() , e.getY() );
			}
		};
		imagePanel.addMouseListener(listener);
	}

	public ImagePanel getImagePanel() {
		return imagePanel;
	}

	public void setImagePanel(ImagePanel imagePanel) {
		this.imagePanel = imagePanel;
	}

	public JMenuItem getOpenOption() {
		return openOption;
	}

	public void setOpenOption(JMenuItem openOption) {
		this.openOption = openOption;
	}

	public JTextArea getReportScreen() {
		return reportScreen;
	}

	public void setReportScreen(JTextArea reportScreen) {
		this.reportScreen = reportScreen;
	} 
	

}
