package com.main;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Trail extends GameObj{

	private float alpha = 1;
	private Handler handler;
	private Color color;
	private int width;
	private int height;
	private float life;
	
	public Trail(int x, int y, Id id, Color color, int width, int height, float life, Handler handler) {
		super(x, y, id);
		this.setHandler(handler);
		this.setWidth(width);
		this.setHeight(height);
		this.setLife(life);
	}

	@Override
	public void tick() {
		if(alpha > life){
			alpha -= life - 0.001f;
		}else{
			this.getHandler().remove(this);
		}
	}

	@Override
	public void render(Graphics g) {
		Graphics2D g2d;
		
		g2d = (Graphics2D) g;
		g2d.setComposite(this.makeTransparent(alpha));
		g.setColor(getColor());
		g.fillRect(x, y, width, height);
		g2d.setComposite(this.makeTransparent(1));
		
	}
	
	private AlphaComposite makeTransparent(float alpha){
		int type = AlphaComposite.SRC_OVER;
		AlphaComposite ac = AlphaComposite.getInstance(type, alpha);
		return ac;
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public float getAlpha() {
		return alpha;
	}

	public void setAlpha(float alpha) {
		this.alpha = alpha;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public float getLife() {
		return life;
	}

	public void setLife(float life) {
		this.life = life;
	}

}
