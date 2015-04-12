package com.seancheey;


import java.awt.Color;
import javax.swing.JFrame;

public class Main {
	
	// Program variables
	public static final String NAME = "Moving fishes";
	public static final int WIDTH = 500, HEIGHT = 500;
	public static int DELAY = 5;

	public static void main(String[] args) {
		JFrame f = new MainFrame(NAME);
		f.setVisible(true);
	}
	
	// Library Functions
	public static Color randColor() {
		int r = (int)(Math.random() * 256);
		int g = (int)(Math.random() * 256);
		int b = (int)(Math.random() * 256);
		return new Color(r, g, b);
	}
	
}