package com.seancheey.data;

import java.awt.Graphics;
import java.awt.Color;
import com.seancheey.Main;

public class RectFish extends Fish {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Color color;
	
	// Constructor list
	public RectFish(int width, int height, double x, double y, double vx, double vy, Pond pond) {
		this(width, height, x, y, vx, vy, pond, Main.randColor()); //Give a random color to fish
	}
	
	public RectFish(int width, int height, double x, double y, double vx, double vy, Pond pond, Color c) {
		super(width, height, x, y, vx, vy, pond);
		color = c;
	}
	
	// Draw itself
	@Override
	protected void paint(Graphics g) {
		g.setColor(color);
		g.fillRect((int) (x - width / 2), (int) (y - height / 2), width, height);
	}
	
	
	// ***Main Algorithm is here!!!***
	@Override
	protected void move() {
		// Touch the wall to reflect
		if (x > getPond().getWidth() || x < 0) {
			vx *= -0.92;
		}
		if (y > getPond().getHeight() || y < 0) {
			vy *= -0.92;
		}
		
		// Prevent the ball from sticking into wall
		// Haha, asean!
		if (x > getPond().getWidth()) {
			x = Main.WIDTH-width;
		}
		if (y > getPond().getHeight() ) {
			y = Main.HEIGHT-height;
		}
		if (x < 0) {
			x = width;
		}
		if (y < 0) {
			y = height;
		}
		
		// Make a move
		x += vx;
		y += vy;
		
		// Pick a random fish & close to it. 
		Fish randFish=pond.getFishes().get(Math.abs((int)x%pond.getFishes().size()));
		vx+=(randFish.getX()-x)/1000;
		vy+=(randFish.getY()-y)/1000;
	}
}
