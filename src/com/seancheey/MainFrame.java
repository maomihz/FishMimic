package com.seancheey;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import com.seancheey.data.Pond;
import com.seancheey.data.RectFish;

public class MainFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	PondPanel pondP;
	
	public MainFrame(String title) {
		super(title);
		setUndecorated(false); // NOT hide title bar
		setSize(Main.WIDTH, Main.HEIGHT); 
		setLocationRelativeTo(null); //Center the window
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Click x to exit program
		
		// Initialize objects
		Pond p = new Pond(Main.WIDTH, Main.HEIGHT);
		for (int i = 0; i < 50; i++)
			p.getFishes().add(new RectFish(10, 10, // size
					Main.WIDTH / 2, Main.HEIGHT / 2, // x, y(center)
					Math.random() * 5 - 2.5, Math.random() * 5 - 2.5, //Random Initial Velocity
					p));
		
		pondP = new PondPanel(p);
		getContentPane().add(pondP);
		
	}
}
