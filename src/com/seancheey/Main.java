package com.seancheey;


import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import com.seancheey.data.*;

public class Main {
	public static final String NAME = "Moving fishes";
	public static final int WIDTH = 500, HEIGHT = 500;
	public static int DELAY = 5;

	public static void main(String[] args) {
		// init the pond
		Pond p = new Pond(WIDTH, HEIGHT);
		for (int i = 0; i < 50; i++)
			p.getFishes().add(
					new RectFish(10, 10, 250, 250, Math.random() * 5 - 2.5,
							Math.random() * 5 - 2.5, p));
		
		// add it to a pond panel
		PondPanel pondP = new PondPanel(p);
		
		// create a new JFrame and add the panel
		JFrame f = new MainFrame(NAME);
		f.setVisible(true);
		f.getContentPane().add(pondP);
	}
	
	// Library Functions
	public static Color randColor() {
		int r = (int)(Math.random() * 256);
		int g = (int)(Math.random() * 256);
		int b = (int)(Math.random() * 256);
		return new Color(r, g, b);
	}
	
}

class MainFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	MainFrame(String title) {
		super(title);
		setUndecorated(false); // NOT hide title bar
		setSize(Main.WIDTH, Main.HEIGHT); 
		setLocationRelativeTo(null); //Center the window
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Click x to exit program
	}
	
}

class PondPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final Pond pond;

	public PondPanel(Pond pond) {
		super();
		this.pond = pond;
		setSize(Main.WIDTH, Main.HEIGHT);
		setBackground(Color.CYAN);
		
		new Thread() {
			public void run() {
				while(true) {
					try {
						sleep(Main.DELAY);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					PondPanel.this.repaint();
				}
			}
		}.start();
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		pond.nextMove();
		pond.paint(g);
	}

}
