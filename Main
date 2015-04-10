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
}

class MainFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	MainFrame(String title) {
		super(title);
		this.setUndecorated(true);
		setSize(Main.WIDTH, Main.HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
	}

	@Override
	protected void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);
		arg0.setColor(Color.RED);
		pond.nextMove();
		pond.paint(arg0);
		try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.repaint();
	}

}
