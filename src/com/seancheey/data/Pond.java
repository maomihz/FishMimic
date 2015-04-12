package com.seancheey.data;


import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

public class Pond {
	private final int width, height; // The pond's size
	private final ArrayList<Fish> fishes; // Container of the pond

	public Pond(int width, int height, ArrayList<Fish> fishes) {
		super();
		this.width = width;
		this.height = height;
		this.fishes = fishes;
	}
	
	public Pond(int width, int height) {
		this(width, height, new ArrayList<Fish>(10));
	}

	@Override
	public boolean equals(Object obj) {
		// null or not in the same class
		if (obj == null || getClass() != obj.getClass())
			return false;
		
		// Objects are identical
		if (this == obj)
			return true;
		
		// Type cast
		Pond other = (Pond) obj;
		
		if (fishes == null || other.fishes == null || !fishes.equals(other.fishes)) 
				return false;
		
		// Size mismatch
		if (height != other.height || width != other.width)
			return false;
		
		return true;
	}
	
	// List of getters
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public ArrayList<Fish> getFishes() {
		return fishes;
	}
	
	// Paint itself
	public void paint(Graphics g) {
		Iterator<Fish> i = fishes.iterator();
		while (i.hasNext()) {
			i.next().paint(g);
		}
	}
	
	// Invoke next move
	public void nextMove() {
		Iterator<Fish> i = fishes.iterator();
		while (i.hasNext()) {
			i.next().move();
		}
	}
	
}
