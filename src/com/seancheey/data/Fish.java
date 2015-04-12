package com.seancheey.data;


import java.awt.Graphics;
import java.io.Serializable;

public abstract class Fish implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected int width, height;  // The fish's width and height
	protected double x, y, vx, vy;  // The fish's location and velocity
	protected final Pond pond; // The Pond the fish belongs to
	
	// Constructor
	public Fish(int width, int height, double x, double y, double vx, double vy, Pond pond) {
		super();
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		this.vx = vx;
		this.vy = vy;
		this.pond = pond;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	// List of getters 
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getVx() {
		return vx;
	}

	public double getVy() {
		return vy;
	}

	public Pond getPond() {
		return pond;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + height;
		result = prime * result + ((pond == null) ? 0 : pond.hashCode());
		long temp;
		temp = Double.doubleToLongBits(vx);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(vy);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + width;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		
		// If the object is null or not in the same class, return false. 
		if (obj == null || getClass() != obj.getClass()) 
			return false;
		
		// If the objects are identical, return true. 
		if (this == obj) 
			return true;
		
		// Cast to Fish Object
		Fish another = (Fish) obj;
		
		// Size Mismatch
		if (height != another.height || width != another.width)
			return false;
		
		// Pond Mismatch
		if (pond == null || another.pond == null || !pond.equals(another.pond) ) {
			return false;
		}
		
		// Velocity Mismatch 
		if (Double.doubleToLongBits(vx) != Double.doubleToLongBits(another.vx) ||
				Double.doubleToLongBits(vy) != Double.doubleToLongBits(another.vy))
			return false;
		
		// Location Mismatch
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(another.x) ||
				Double.doubleToLongBits(y) != Double.doubleToLongBits(another.y))
			return false;
		
		return true;
	}

	@Override
	public String toString() {
		return String.format("Fish [width = %d, height = %d, x = %f.2, y = %f.2, vx = %f.5, vy = %f.5, pond = %s]"
				, width, height, x, y, vx, vy, pond);
	}

	protected abstract void move();

	protected abstract void paint(Graphics g);
}
