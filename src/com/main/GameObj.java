package com.main;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObj {

	protected int x;
	protected int y;
	protected Id id;
	protected int velX;
	protected int velY;
	
	public GameObj(int x, int y, Id id){
		
		this.setX(x);
		this.setY(y);
		this.setId(id);
		
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Id getId() {
		return id;
	}

	public void setId(Id id) {
		this.id = id;
	}

	public int getVelX() {
		return velX;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public int getVelY() {
		return velY;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}
	
}
