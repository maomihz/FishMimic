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