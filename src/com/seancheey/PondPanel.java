package com.seancheey;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import com.seancheey.data.Pond;

public class PondPanel extends JPanel {
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
		
		// Keep updating
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
